<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<%@page import="com.ips.bean.RegistrationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ips.manager.CourtManager"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>View All Police</title>
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
        <script type="text/javascript">
            function deletePolice(policeId) {
                var r = confirm("Do you want to delete ?");
                if (r == true) {
                    $.get('DeletePolice',{id:policeId});
                } 
                
            }
        </script>

    </head>
    <body id="page5">
        <!-- START PAGE SOURCE -->

        <%

                    Object obj = session.getAttribute(AppConstants.USER_BEAN);
                    if (obj != null && obj instanceof LoginBean) {
                        LoginBean loginBean = (LoginBean) obj;
                        if (loginBean.getUserType().equals(AppConstants.TYPE_USER)) {
        %>



        <%
                                    String status = request.getParameter("status");
                                    if (status != null && !status.equals("") && status.equals("delete")) {
        %>
        <h1 style="color: red"><center> Police Deleted Successfully.....</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("notdelete")) {%>
        <h1 style="color: red"><center>Police Deleted Successfully....</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("updatepolice")) {%>
        <h1 style="color: red"><center>Police Deletion Failed..</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("updatepolice")) {%>
        <h1 style="color: red"><center>Police Update Successfully..</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("notupdatepolice")) {%>
        <h1 style="color: red"><center>Police Updation Failed..</center></h1>
        <%}%>
        <div class="body2"><div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li><a href="Police.jsp">Home</a></li>
                                <li><a href="CaseRegistration.jsp">Add Cases </a></li>
                                <li><a href="ViewForwardCase.jsp">Forward Cases</a></li>
                                <li ><a href="PoliceRegistration.jsp">Add Police</a></li>
                                <li id="menu_active" class="bg_none">
                                    <a href="viewPolice.jsp">View Police</a></li>
                                <li><a href="CourtRegistration.jsp">Add Court</a></li>
                                <li><a href="ViewCourt.jsp">View Court</a></li>
                                <li ><a href="ViewReportPolice.jsp">Report</a></li>
                                <li><a href="LogOutServlet">Logout</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p>The security police are one of the most ubiquitous organizations of the society.The security police,
                                therefore, happen to be the most visible representatives of the government.Their roles,functions and
                                duties in the society are natural to be varied, and multifarious on the one hand; and complicated,
                                knotty and complex on the other.
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
                        <h2><b>View All Police</b></h2>
                        <p>&nbsp;</p>
                    </article>
                    <article class="pad_left1 col2">
                        <h2>&nbsp;</h2>
                    </article>
                </section>
            </div>
        </div>

        <center>
            <br />
            <table width="803" border="2">
                <tr style="background-image:url(images/bot.jpg);color: white">
                    <td width="111"><center>Sl</center>
                    </td>
                    <td width="161"><center> Police Id</center></td>
                    <td width="161"><center> Name</center></td>
                    <!--<td width="151"><center>View</center></td>-->
                    <td width="177"><center>Edit</center></td>
                    <td width="112"><center>Delete</center></td>
                </tr>
                <tr>
                    <td width="111">&nbsp;</td>
                    <td width="161">&nbsp;</td>
                    <td width="161">&nbsp;</td>
                    <td width="177">&nbsp;</td>
                    <td width="112">&nbsp;</td>
                </tr>
                <%
                                            CourtManager courtManager = new CourtManager();
                                            ArrayList list = courtManager.getPolice();
                                            for (int i = 0; i < list.size(); i++) {
                                                RegistrationBean registrationBean = (RegistrationBean) list.get(i);
                %>

                <tr>
                    <td><center><%=(i + 1)%></center></td>
                    <td><center><%=registrationBean.getId()%></center></td>
                    <td><center><%=registrationBean.getName()%></center></td>
                    <!-- <td><center>view</center></td>-->
                    <td><center><a href="EditPolice.jsp?id=<%=registrationBean.getId()%>">Edit</a></center></td>
                    <td><center><a href="" onclick="deletePolice(<%=registrationBean.getId()%>)">Delete</a></center></td>
                </tr>
                <%}%>
            </table>
        </center>
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
                    <li >
                        <a href="Police.jsp">Home</a></li>
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