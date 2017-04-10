<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<%@page import="com.ips.bean.CaseBean"%>
<%@page import="com.ips.manager.CourtManager"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Case Details</title>
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
            -->
        </style>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css" />
        <script>
            $(function() {
                $( "#datepicker" ).datepicker();
            });
        </script>
        <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAgrj58PbXr2YriiRDqbnL1RSqrCjdkglBijPNIIYrqkVvD1R4QxRl47Yh2D_0C1l5KXQJGrbkSDvXFA"
        type="text/javascript"></script>
        <script type="text/javascript">

            function load(l,m) {
                if (GBrowserIsCompatible()) {
                    var map = new GMap2(document.getElementById("map"));
                    map.addControl(new GSmallMapControl());
                    map.addControl(new GMapTypeControl());
                    var center = new GLatLng(l,m);
                    map.setCenter(center, 15);
                    geocoder = new GClientGeocoder();
                    var marker = new GMarker(center, {draggable: true});
                    map.addOverlay(marker);


                    GEvent.addListener(map, "moveend", function() {
                        map.clearOverlays();
                        var center = map.getCenter();
                        var marker = new GMarker(center, {draggable: true});
                        map.addOverlay(marker);
                        //  document.getElementById("lat").innerHTML = center.lat().toFixed(5);
                        // document.getElementById("lng").innerHTML = center.lng().toFixed(5);


                    });

                }
            }

        </script>

        <style type="text/css">
            <!--
            #apDiv2 {
                position:absolute;
                width:313px;
                height:540px;
                z-index:3;
                left: 688px;
                top: 115px;
            }
            #apDiv3 {
                position:absolute;
                width:200px;
                height:115px;
                z-index:3;
                left: 888px;
                top: 774px;
            }
            -->
        </style>
    </head>
    <%
                String id = request.getParameter("id");
                CourtManager courtManager = new CourtManager();
                CaseBean caseBean = courtManager.getOneCase(id);

    %>
    <!-- <body id="page5" onLoad="load('10.78673','76.65479')" onUnload="GUnload()" >-->

    <body id="page5" onLoad="load('<%=caseBean.getLat()%>','<%=caseBean.getLog()%>')" onUnload="GUnload()" >

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
                            <p><span class="marg_top">Traffic wardens should have sufficient time to regulate
                                    traffic at the given main crossing at least two days in a
                                    week for 3 hours at peak hours. However they will be contacted
                                    by traffic police as and when the situation warrants.
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
                    <h2 class="title">View Case Details :</h2>
                    <form name="form1" id="form1" method="post" action="#">
                        <ul id="form_fields"><li>
                            <li><strong> Case ID  :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getCase_id()%>" disabled="true"  />
                            </li>
                            <li><strong>Suspect Name :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getSuspect_Name()%>" disabled="true"/>
                            </li>
                            <li><strong>Suspect Aadhaar No :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getSuspect_AddarNo()%>" disabled="true"  />
                            </li>
                            <li><strong> Phone :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getPhone()%>" disabled="true" />
                            </li>
                            <li><strong>Email :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getEmail()%>" disabled="true"/>
                            </li>
                            <li><strong>Vehicle No:</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getVehicle_No()%>" disabled="true" />
                            </li>
                            <li><strong>Victim Adhaar No :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getVictim_Adhaar_No()%>" disabled="true" />
                            </li>
                            <li><strong> Date :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getDate()%>" disabled="true" />
                            </li>
                            <li><strong>Case Type :</strong></li>
                            <li>
                                <input type="text" value="<%=caseBean.getCase_type()%>" disabled="true" />
                            </li>
                            <li><strong>Case Commands :</strong></li>
                            <li>                                
                                <textarea rows="5" cols="31" name="address" id="address" style="border: 3px solid #EAEAEA; background:#ffffff" disabled="true"><%=caseBean.getCase_Comands()%></textarea>
                            </li>
                        </ul>

                        <!-- show image -->
                        <div>
                            <p> <strong><u>Image File ..</u></strong></p>
                            <img src="<%="Filefolder/Temp/" + caseBean.getCase_id() + ".jpg"%>" height="240px" width="280"/>
                            <!-- Show video-->
                            <div style="padding-left:310px; margin-top: -27%" >
                                <embed width="320" height="240" src="<%="Filefolder/Temp/" + caseBean.getCase_id() + ".mp4"%>"></embed>
                                            </div>
                                            </div>


                                            <td>&nbsp;</td>
                                            <ul>
                                                <li ></li>
                                                <li ></li>
                                            </ul>
                                            </form>


                                            <div id="apDiv2">
                                                <div  style="width: 325px; height: 470px">
                                                    <p>
                                                    <div align="center" id="map" style="width: 325px; height: 410px"><br/></div>
                                                    </p>
                                                </div>
                                            </div>

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