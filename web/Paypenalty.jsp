<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<%@page import="com.ips.bean.CaseBean"%>
<%@page import="com.ips.manager.CaseManager"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS pay Penalty</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.4.2.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>
        <script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
        <style type="text/css">
            <!--
            #apDiv1 {
                position:absolute;
                width:243px;
                height:157px;
                z-index:3;
                left: 314px;
                top: 3px;
            }
            #apDiv2 {
                position:absolute;
                width:200px;
                height:4px;
                z-index:3;
                left: 537px;
                top: 97px;
            }
            #apDiv3 {
                position:absolute;
                width:415px;
                height:376px;
                z-index:3;
                left: 473px;
                top: 1px;
            }
            -->
        </style>
    </head>
    <body id="page5">
        <!-- START PAGE SOURCE -->
        <%

                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-store");
                    response.setHeader("Expires", "0");
                    response.setDateHeader("Expires", -1);


                    Object obj = session.getAttribute(AppConstants.USER_BEAN);
                    if (obj != null && obj instanceof LoginBean) {
                        LoginBean loginBean = (LoginBean) obj;
                        if (loginBean.getUserType().equals(AppConstants.TYPE_USER1)) {
        %>

        <div class="body1"></div>
        <div class="body2">
            <div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li id="menu_active" class="bg_none">
                                    <a href="Court.jsp">Home</a></li>
                                <li><a href="ViewPenaltys.jsp">View Penalty</a></li>
                                <li><a href="ViewReportCourt.jsp">View Report</a></li>
                                <li><a href="LogOutServlet">Logout</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p><span class="marg_top">If a traffic policeman gives you instructions on the
                                    road, it is your duty to obey them, regardless of what the electronic
                                    traffic signals say. When a traffic policeman is stationed at a
                                    signal/crossing, he is the final authority.</span>
                            </p>
                        </article>
                    </div>
                </header>
            </div>
        </div>
        <div class="body3">
            <div class="main">
                <section id="content_top">
                    <article class="pad_left2 col3">
                        <h2>&nbsp;</h2>
                    </article>
                    <article class="pad_left1 col2">
                        <h2>&nbsp;</h2>
                    </article>
                </section>
            </div>
        </div>
        <div class="main">
            <section id="content">
                <article class="pad_left2">
                    <h2 class="title">Pay Penalty :</h2>
                    <%
                                                CaseBean caseBean = null;
                                                String id = request.getParameter("id");
                                                if (!id.equals("") && id != null) {
                                                    CaseManager caseManager = new CaseManager();
                                                    caseBean = caseManager.getPayPenalty(id);
                                                }

                    %>

                    <form name="form1" id="form1" method="post" action="PayPenalty?id=<%=caseBean.getCase_id()%>&email=<%=caseBean.getEmail()%>">
                        <ul id="form_fields"><li>
                            <li><strong>Suspect Name:</strong></li>
                            <li> <input type="text" name="name" id="name" value="<%=caseBean.getSuspect_Name()%>"/></li>
                            <li><strong>Penalty ATM:</strong></li>
                            <li><input type="text" name="atm" id="atm" value="<%=caseBean.getPanalty_atm()%>" />
                                <div id="apDiv3" style="background-image:url(images/pay_or_play1.jpg)"></div>
                            </li>
                            <li><strong>Penalty Status:</strong></li>
                            <li><input type="text" name="status" id="status" value="<%=caseBean.getPanalty_status()%>" /></li>
                            <li></li>
                            <li></li>
                            <li>&nbsp; </li>
                            <li ><input type="submit" name="submit"  value="Submit"  style="margin-right:0px; margin-top:0px; width:60px; height:35px; background-image:url(images/Button.png);color: white"/></li>
                        </ul>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <ul>
                            <li ></li>
                        </ul>
                    </form>
                </article>
            </section>
        </div>
        <div class="body4">
            <div class="main">
                <div id="footer_menu">
                    <nav>
                        <ul>
                            <li><a href="Court.jsp">Home</a></li>
                            <li><a href="ViewPenaltys.jsp">View Penalty</a></li>
                            <li><a href="ViewReportCourt.jsp">View Report</a></li>
                            <li><a href="LogOutServlet">Logout</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    <footer></footer>
    <script type="text/javascript"> Cufon.now(); </script>
    <!-- END PAGE SOURCE -->
    <div align=center></div>
    <%}
                } else {
                    response.sendRedirect("index.jsp");
                }
    %>
</body>
</html>