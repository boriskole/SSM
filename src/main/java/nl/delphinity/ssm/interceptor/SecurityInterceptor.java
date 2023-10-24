package nl.delphinity.ssm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.domain.SecuredAction;
import nl.delphinity.ssm.domain.type.PersoonType;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class SecurityInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        SecuredAction annotation = invocation.getAction().getClass().getAnnotation(SecuredAction.class);
        Account account = (Account) invocation.getInvocationContext().getSession().get("account");

        if (annotation == null)
            return invocation.invoke();

        if (account == null)
            return "403";

        if (annotation.type() == PersoonType.BEHEERDER && account.getPersoon().isBeheerder())
            return invocation.invoke();
        else if (annotation.type() == PersoonType.KLANT && !account.getPersoon().isBeheerder())
            return invocation.invoke();

        return "403";

    }

}
