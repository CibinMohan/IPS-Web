<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<%@page import="com.ips.manager.CourtManager"%>
<%@page import="com.ips.bean.CaseBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ips.manager.PoliceManager"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Case History</title>
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
                width:858px;
                height:78px;
                z-index:3;
                left: 7px;
                top: 54px;
            }
            #apDiv2 {
                position:absolute;
                width:322px;
                height:46px;
                z-index:1;
                left: 775px;
                top: 381px;
            }
            #apDiv3 {
                position:absolute;
                width:406px;
                height:41px;
                z-index:3;
                left: 691px;
                top: 413px;
            }
            #apDiv4 {
                position:absolute;
                width:308px;
                height:96px;
                z-index:3;
                left: 788px;
                top: 300px;
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

        <div class="body2"><div class="main">
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
                            <p>The most common traffic violations, according to the Los Angeles Police Department, are:
                                failing to stop for a red light; driving under the influence of alcohol and/or drugs;
                                driving faster than the speed limit; making an unsafe left turn when opposing traffic
                                has the right of way; and following too closely behind other vehicles.
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
                        <h2><b>View History</b> :</h2>
                    </article>
                    <article class="pad_left1 col2">
                        <h2>&nbsp;</h2>
                    </article>
                </section>
            </div>
        </div>
        <%
                                    ArrayList list = null;
                                    //PoliceManager manager = new PoliceManager();
                                    CourtManager courtManager = new CourtManager();
                                    String no = request.getParameter("no");
                                    if (no != null && !no.equals("")) {
                                        list = courtManager.getHistoryToCourt(no);

                                        if (!list.isEmpty()) {
                                            for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i) instanceof CaseBean) {
                                                    CaseBean caseBean = (CaseBean) list.get(i);
        %>

        <center>
            <p>
            <h2> Case Id       : <%=caseBean.getCase_id()%> <br />
                Suspect Name  : <%=caseBean.getSuspect_Name()%> <br />
                Case Type     :  <%=caseBean.getCase_type()%> <br />
                Comments      : <%=caseBean.getCase_Comands()%> <br />
            </h2>
        </p>
    </center>
    <%}

                                                }
                                            }
                                        } else {%>
    <h2><center><b>This Vehicle_No does not reported any Case yet...</b></center></h2>

    <%}%>



    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
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
<footer>
    <div class="footerlink">

    </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
<!-- END PAGE SOURCE -->
<div ></div>
<%}
            } else {
                response.sendRedirect("index.jsp");
            }
%>
</body>

</html>