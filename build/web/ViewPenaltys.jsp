<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<%@page import="com.ips.manager.SearchManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ips.bean.CaseBean"%>
<%@page import="com.ips.manager.CaseManager"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS view penalty</title>
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
            <!--
            function MM_preloadImages() { //v3.0
                var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
                    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
                        if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
                }
                //-->
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
                        if (loginBean.getUserType().equals(AppConstants.TYPE_USER1)) {
        %>


        <%
                                    String status = request.getParameter("status");
                                    if (status != null && !status.equals("") && status.equals("pay")) {
        %>
        <h1 style="color: red"><center>Pay Penalty Success...</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("notepay")) {%>
        <h1 style="color: red"><center>Pay Penalty Failed...</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("set")) {%>
        <h1 style="color: red"><center>Penalty Reset</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("notset")) {%>
        <h1 style="color: red"><center>Penalty Reset Failed...</center></h1>
        <%}%>

        <div class="body2"><div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li><a href="Court.jsp">Home</a></li>
                                <li id="menu_active" class="bg_none" >
                                    <a href="ViewPenaltys.jsp">View Penalty</a></li>
                                <li><a href="ViewReportCourt.jsp">View Report</a></li>
                                <li><a href="LogOutServlet">Logout</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p>Security police protect their agency's facilities,
                                properties,   personnel, users, visitors and operations
                                from harm and may enforce   certain laws and
                                administrative regulations.
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
                        <h2><b>View All Cases </b></h2>
                    </article>
                    <article class="pad_left1 col2">


                        <div>
                            <br/>
                            <br />
                            <form name="form1" id="form1" method="post" action="#" >
                                <input type="radio" name="opt" id="opt" value="CaseId"/>
                                <label style="font-size:14px;"><strong>Case Id</strong></label>
                                <input type="radio" name="opt" id="opt" value="addharNO"/>
                                <label style="font-size:14px;"><strong>Aadhaar No</strong></label>
                                <input type="radio" name="opt" id="opt" value="vechicleNO"/>
                                <label style="font-size:14px;"><strong>Vehicle No</strong></label>
                                <input type="text" name="search" id="search" style="border: 2px solid #EAEAEA;" />
                                <input type="submit" id="searchButton" width="90px" height="20px" value="Search" />
                            </form>
                        </div>

                    </article>
                </section>
            </div>
        </div>

        <center>
            <br />
            <table width="803" border="2">
                <tr style="background-image:url(images/bot.jpg);color: white">
                    <th width="50"><center>Sl</center> </th>
                    <th width="200"> <center> Case Id</center></th>
                    <th width="216"> <center>Suspect Name</center></th>
                    <th width="151"><center>Pay Penalty</center></th>
                </tr>
                <tr>
                    <td width="111">&nbsp;</td>
                    <td width="216">&nbsp;</td>
                    <td width="216">&nbsp;</td>
                    <td width="151">&nbsp;</td>
                </tr>
                <%
                                            CaseManager caseManager = new CaseManager();
                                            SearchManager searchManager = new SearchManager();
                                            CaseBean caseBean = null;
                                            ArrayList list = null;
                                            String option = request.getParameter("opt");
                                            String value = request.getParameter("search");
                                            if (option != null && !option.equals("") && value != null && !value.equals("")) {
                                                if (option.equals("CaseId")) {
                                                    list = searchManager.getSearchPenaltyCaseId(value);
                                                } else if (option.equals("addharNO")) {
                                                    list = searchManager.getSearchPenaltyCasesAddharNo(value);
                                                } else if (option.equals("vechicleNO")) {
                                                    list = searchManager.getSearchPenaltyCasesvechicleNO(value);
                                                }
                                            } else {
                                                list = caseManager.getPenaltyCases();
                                            }
                                            if (!list.isEmpty()) {
                                                for (int i = 0; i < list.size(); i++) {
                                                    Object object = list.get(i);
                                                    if (object instanceof CaseBean) {
                                                        caseBean = (CaseBean) object;
                                                    }
                                                    if (Integer.parseInt(caseBean.getDate_diff()) >= 1) {

                %>

                <tr  style="background-color:#FFFF33">
                    <td><center><%=(i + 1)%></center></td>
                    <td><center><%=caseBean.getCase_id()%></center></td>
                    <td><center><%=caseBean.getSuspect_Name()%></center></td>
                    <td><center><a href="ReSetpenalty.jsp?id=<%=caseBean.getCase_id()%>">Re-Penalty</a></center></td>
                </tr>
                <%} else {%>
                <tr>
                    <td><center><%=(i + 1)%></center></td>
                    <td><center><%=caseBean.getCase_id()%></center></td>
                    <td><center><%=caseBean.getSuspect_Name()%></center></td>
                    <td><center><a href="Paypenalty.jsp?id=<%=caseBean.getCase_id()%>">Pay</a></center></td>
                </tr>
                <%     }
                                                                }
                                                            } else {%>
                <h1 style="color: red" >No Response...</h1>

                <%
                                                                list = caseManager.getPenaltyCases();
                                                                for (int i = 0; i < list.size(); i++) {
                                                                    Object object = list.get(i);
                                                                    if (object instanceof CaseBean) {
                                                                        caseBean = (CaseBean) object;
                                                                    }
                                                                    if (Integer.parseInt(caseBean.getDate_diff()) >= 1) {
                %>
                <tr  style="background-color:#FFFF33">
                    <td><center><%=(i + 1)%></center></td>
                    <td><center><%=caseBean.getCase_id()%></center></td>
                    <td><center><%=caseBean.getSuspect_Name()%></center></td>
                    <td><center><a href="ReSetpenalty.jsp?id=<%=caseBean.getCase_id()%>">Re-Penalty</a></center></td>
                </tr>
                <%} else {%>
                <tr>
                    <td><center><%=(i + 1)%></center></td>
                    <td><center><%=caseBean.getCase_id()%></center></td>
                    <td><center><%=caseBean.getSuspect_Name()%></center></td>
                    <td><center><a href="Paypenalty.jsp?id=<%=caseBean.getCase_id()%>">Pay</a></center></td>
                </tr>
                <%}
                                                }
                                            }%>

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