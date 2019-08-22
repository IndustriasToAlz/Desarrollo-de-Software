package com.daserva.utils;

import static com.daserva.utils.ConstantsText.ERROR_CODE;
import static com.daserva.utils.ConstantsText.ERROR_MESSAGE;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

public abstract class ControllerServlet {

    @FunctionalInterface
    public interface Operation {

        public JSONObject apply(Connection con, JSONObject data) throws Exception;
    }

    @FunctionalInterface
    public interface OperationGET {

        public JSONObject apply(Connection con) throws Exception;
    }

    @FunctionalInterface
    public interface OperationUpload {

        public String apply(MultipartFile file, String subfix, String folder) throws IOException;
    }

    public static final String KEY_PERMISSIONS_SESSION = "permissions";
    public static final String KEY_USER_SESSION = "user";

    protected boolean isFailed(JSONObject result) {
        return result.has(ERROR_CODE);
    }

    protected ResponseEntity<String> toResponseEntity(JSONObject result) {
        if (isFailed(result)) {
            return ResponseEntity
                    .status(result.getInt(ERROR_CODE))
                    .body(result.getString(ERROR_MESSAGE));
        }

        return ResponseEntity.ok(result.toString());
    }

    protected JSONObject makeErrorJSON(HttpStatus status, String msg) {
        JSONObject result = new JSONObject();
        result.put(ERROR_CODE, status.value());
        result.put(ERROR_MESSAGE, msg);

        return result;
    }

    public JSONObject handleException(String msg, Exception ex,
            HttpStatus status, Connection con) {

        return handleException(msg, ex, status, con, new JSONObject());
    }

    public JSONObject handleException(String msg, Exception ex,
            HttpStatus status, Connection con, JSONObject data) {
        String newMsg = ex.getMessage();
        newMsg = newMsg == null ? msg : newMsg;

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        String msgRequest = request.getRequestURL().toString();
        msgRequest = String.format("Petición errada: %s %n Datos: %s", msgRequest, data.toString());

        Logger.getLogger(ControllerServlet.class.getSimpleName()).log(Level.SEVERE, msgRequest);
        Logger.getLogger(ControllerServlet.class.getSimpleName()).log(Level.SEVERE, newMsg, ex);
        try {
            doRollback(con);
        } catch (SQLException ex1) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return makeErrorJSON(status, newMsg);
    }

    public void doRollback(Connection con) throws SQLException {
        if (con != null && !con.getAutoCommit() && !con.isClosed()) {
            con.rollback();
        }
    }

    private HttpSession getCurrentSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }

    protected void invalidateCurrentSession() {
        HttpSession session = getCurrentSession();
        session.invalidate();
    }

}
