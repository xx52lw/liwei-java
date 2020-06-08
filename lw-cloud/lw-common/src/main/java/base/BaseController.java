package base;


import enums.SystemContext;
import enums.SystemContextType;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
public abstract class BaseController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取当前用户信息
     * @return
     */
    public User getCurrentUser() {
        return SystemContext.getCurrentValue(SystemContextType.CURRENT_ORG.CURRENT_USER, User.class);
    }

    /**
     * 获取当前组织ID
     * @return
     */
    public Long getCurrentOrgId() {
        String orgId = SystemContext.getCurrentValue(SystemContextType.CURRENT_ORG, String.class);
        if(StringUtils.isBlank(orgId)) {
            return null;
        }
        return Long.parseLong(orgId);
    }



}
