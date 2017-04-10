<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<%@page import="com.ips.manager.DataAnalysis"%>
<%@page import="com.ips.manager.CourtManager"%>
<%@page import="com.ips.bean.CaseBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ips.manager.PoliceManager"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> IPS View Report</title>
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

        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
            <%
                        int i = 0;
                        // Manager manager = new Manager();
                        // ArrayList list = manager.getDateInMonth();
                        //  ArrayList list = manager.getValue();
                        DataAnalysis analysis = new DataAnalysis();
                        ArrayList list = analysis.getValue();
                        int value[] = new int[6];
                        for (Object object : list) {
                            int number = (Integer) object;
                            value[i++] = number;
                        }
                        if (value.length > 0) {
            %>

                google.load('visualization', '1');   // Don't need to specify chart libraries!
                google.setOnLoadCallback(drawVisualization);

                function drawVisualization() {
                    var wrapper = new google.visualization.ChartWrapper({
                        chartType: 'ColumnChart',
                        dataTable: [['', 'Documents', 'Driving', 'Speed & Overtaking', 'Pollution', 'Parking', 'Signal'],
                            ['',<%=value[0]%>, <%=value[1]%>, <%=value[2]%>, <%=value[3]%>, <%=value[4]%>, <%=value[5]%>]],
                        options: {'title': 'Accidents in current month..'},
                        containerId: 'vis_div'
                    });
                    wrapper.draw();
                }
            <%}%>
        </script>


        <script type="text/javascript">
            <%
                        i = 0;
                        // Manager manager = new Manager();
                        list = analysis.getDateInWeek();
                        // ArrayList list = manager.getValue();
                        for (Object object : list) {
                            int number = (Integer) object;
                            value[i++] = number;
                        }
                        if (value.length > 0) {
            %>

                google.load('visualization', '1');   // Don't need to specify chart libraries!
                google.setOnLoadCallback(drawVisualization);

                function drawVisualization() {
                    var wrapper = new google.visualization.ChartWrapper({
                        chartType: 'ColumnChart',
                        dataTable: [['', 'Documents', 'Driving', 'Speed & Overtaking', 'Pollution', 'Parking', 'Signal'],
                            ['',<%=value[0]%>, <%=value[1]%>, <%=value[2]%>, <%=value[3]%>, <%=value[4]%>, <%=value[5]%>]],
                        options: {'title': 'Accidents in current week..'},
                        containerId: 'week_main'
                    });
                    wrapper.draw();
                }
            <%}%>
        </script>

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
                        if (loginBean.getUserType().equals(AppConstants.TYPE_USER)) {
        %>


        <div class="body2"><div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                             <ul id="menu">
                                <li><a href="Police.jsp">Home</a></li>
                                <li><a href="CaseRegistration.jsp">Add Cases </a></li>
                                <li><a href="ViewForwardCase.jsp">Forward Cases</a></li>
                                <li><a href="PoliceRegistration.jsp">Add Police</a></li>
                                <li><a href="viewPolice.jsp">View Police</a></li>
                                <li><a href="CourtRegistration.jsp">Add Court</a></li>
                                <li><a href="ViewCourt.jsp">View Court</a></li>
                                <li id="menu_active" class="bg_none">
                                    <a href="ViewReportPolice.jsp">Report</a></li>
                                <li><a href="LogOutServlet">Logout</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p> Traffic police are generally part of an internal division of a law enforcement agency.
                                Their primary responsibility is to enforce state and municipal traffic laws, which is
                                accomplished both by their mere presence on city streets and through the issuance of
                                traffic citations. Traffic police officers are also usually the only division within
                                a police or sheriff's department who use a motorcycle.
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
                        <h2><b>View Report</b> :</h2>
                    </article>
                    <article class="pad_left1 col2">
                        <h2>&nbsp;</h2>
                    </article>
                </section>
            </div>
        </div>

        <center>
            <p>

            <div id="week_main" style="width: 600px; height: 400px;"></div>

            <div id="vis_div" style="width: 600px; height: 400px;"></div>


        </p>
    </center>  
    <p>&nbsp;</p>
</article>
</section>
</div>
<div class="body4">
    <div class="main">
        <div id="footer_menu">
            <nav>
                <ul >
                    <li><a href="Police.jsp">Home</a></li>
                    <li><a href="ViewForwardCase.jsp">View Forward Cases</a></li>
                    <li><a href="PoliceRegistration.jsp">Add Police</a></li>
                    <li><a href="viewPolice.jsp">View Police</a></li>
                    <li><a href="CourtRegistration.jsp">Add Court</a></li>
                    <li><a href="ViewCourt.jsp">View Court</a></li>
                    <li><a href="ViewReportPolice.jsp">View Report</a></li>
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
<div></div>
<%}
            } else {
                response.sendRedirect("index.jsp");
            }
%>
</body>
</html>