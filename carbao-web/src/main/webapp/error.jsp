<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.PrintStream" %>
<%@ page import="java.util.Enumeration" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%Logger logger = LoggerFactory.getLogger(this.getClass());%>
<!DOCTYPE html>

<html>
<head>
    <title>错误信息页面</title>
</head>
<body id="error">
<div class="container">
    <h1>错误信息</h1>
    <%@ include file="/common/messages.jsp" %>
    <!-- <script type="text/javascript">
        function showErrorMessage(){
            $("#errorMessageDiv").toggle();
        }
        $(document).ready(showErrorMessage);
    </script> -->
    <p></p>
    <div id="errorMessageDiv">
            <pre>
                <%
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        PrintStream printStream = new PrintStream(byteArrayOutputStream);

                        printStream.println();
                        printStream.println("用户信息");
                        //printStream.println("账号：" + request.getSession().getAttribute("userName"));
                        printStream.println("访问路径: " + request.getAttribute("javax.servlet.forward.request_uri"));
                        printStream.println();

                        printStream.println("异常信息");
                        printStream.println(exception.getClass() + " : " + exception.getMessage());
                        printStream.println();

                        Enumeration<String> e = request.getParameterNames();
                        if (e.hasMoreElements()) {
                            printStream.println("请求参数：");
                            while (e.hasMoreElements()) {
                                String key = e.nextElement();
                                printStream.println(key + "=" + request.getParameter(key));
                            }
                            printStream.println();
                        }

                        printStream.println("堆栈信息");
                        exception.printStackTrace(printStream);
                        printStream.println();

                        out.print(byteArrayOutputStream);

                    } catch (Exception ex) {
                        //LogUtil.error(logger, LogUtil.SECURITY, "", ex);
                    }
                %>
            </pre>
    </div>
</div>
</body>
</html>
