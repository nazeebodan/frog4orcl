/**
 * 
 */
package com.frog4orcl.framework.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.util.SystemConstant;
import com.frog4orcl.framework.util.TextUtils;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 9:51:16 AM
 * @version: 1.0
 */
public class Frog4oclUrlFilter implements javax.servlet.Filter {

	private String EN_CODING = "UTF-8";
	private static Logger logger = Logger.getLogger(Frog4oclUrlFilter.class);
	private String indexPageUri;
	private List<String> unfilterUriList;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg0.setCharacterEncoding(EN_CODING);
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession();
		String context = request.getContextPath();
		String url = request.getRequestURI();
		try {
			
			if (url.indexOf(indexPageUri) != -1||url.equals(context+"/")||url.indexOf("/login.do")!=-1) {
				arg2.doFilter(arg0, arg1);
			} else {
//				String url2 = TextUtils.checkSuffix(url);
//				if (url2.indexOf("do") == -1 && url2.indexOf("jsp") == -1) {
//					request.setAttribute(SystemConstant.INDEX_MSG, "传送过来的URL请求非法!");
//					((HttpServletResponse) arg1).sendRedirect((new StringBuilder())
//							.append(context).append(indexPageUri).toString());
//					return;
//				}
				Frog4orclBaseMultiActionController helper = (Frog4orclBaseMultiActionController) BeanManager
						.getBean("mainControl");

				if (session != null) {
					ProcessResult<DBManagerImpl> dba = helper
							.checkLogin(request);
					request.getSession().setAttribute(
							SystemConstant.LOGIN_SUC_KEY, dba);
				} else {
					((HttpServletResponse) arg1)
							.sendRedirect((new StringBuilder()).append(context)
									.append(indexPageUri).toString());
					return;
				}
				arg2.doFilter(arg0, arg1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			request.setAttribute(SystemConstant.INDEX_MSG, e.getMessage());
			((HttpServletResponse) arg1).sendRedirect((new StringBuilder())
					.append(context).append(indexPageUri).toString());
			return;
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		unfilterUriList = new ArrayList<String>();
		unfilterUriList.add("/login.do");
		indexPageUri = "/index.jsp";
	}

}
