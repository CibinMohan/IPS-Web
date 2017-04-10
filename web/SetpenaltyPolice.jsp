<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Set Penalty</title>
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
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script type="text/javascript">

            $().ready(function() {
                // validate signup form on keyup and submit
                $("#form1").validate({
                    rules: {
                        name:{
                            required: true,
                            minlength: 2
                        },
                        status: {
                            required: true,
                            minlength: 2
                        },                         
                        atm: {
                            required: true,
                            minlength: 2,
                            digits:true
                           

                        },
                        topic: {
                            required: "#newsletter:checked",
                            minlength: 2
                        },                     
                        agree: "required"
                    },
                    messages: {
                        firstname: "Please enter your firstname",
                        lastname: "Please enter your lastname",
                        status: {
                            required: "Please enter a Status",
                            minlength: "Your Status must consist of at least 2 characters"
                        },                      
                        
                        atm: {
                            required: "Please provide a ATM",
                            minlength: "minmum length 10 digits",
                            digits: "Please enter only digits.",
                            maxlength:"maximum length 10 digits"

                        },
                        email: "Please enter a valid email address",
                        agree: "Please accept our policy"
                    }
                });
            });

            function isNumber(evt) {  //Function for entering only digits
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                //alert(charCode);
                if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode != 46) &&
                    (charCode < 95 || charCode > 105) && (charCode < 37 || charCode > 40)) {
                    return false;
                }
                return true;
            }
            function isLetters(evt) {
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;

                if (charCode > 32 && (charCode < 37 || charCode > 40) && (charCode < 46 || charCode > 46) &&
                    (charCode < 65 || charCode > 90) && (charCode != 190) ) {
                    return false;
                }
                return true;
            }
            function disableField(){
                var field = document.getElementById('status').disabled = true ;
            }
        </script>


        <!-- datepicker -->

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script>
            $(function() {
                $( "#datepicker" ).datepicker();
            });
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

        <div class="body1"></div>
        <div class="body2">
            <div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li id="menu_active" class="bg_none">
                                    <a href="Police.jsp">Home</a></li>
                                <li><a href="CaseRegistration.jsp">Add Cases </a></li>
                                <li><a href="ViewForwardCase.jsp">Forward Cases</a></li>
                                <li><a href="PoliceRegistration.jsp">Add Police</a></li>
                                <li><a href="viewPolice.jsp">View Police</a></li>
                                <li><a href="CourtRegistration.jsp">Add Court</a></li>
                                <li><a href="ViewCourt.jsp">View Court</a></li>
                                <li><a href="ViewReportPolice.jsp">Report</a></li>
                                <li><a href="LogOutServlet">Logout</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p><span class="marg_top">The Highways Agency Traffic Officers have powers to:
                                    Stop traffic and close roads, lanes and carriageways;
                                    Manage traffic and traffic surveys,
                                    Direct and divert traffic.</span>
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
        <div class="main"  style="height:400px;">
            <section id="content">
                <article class="pad_left2">
                    <%
                                                obj = session.getAttribute(AppConstants.USER_BEAN);
                                                if (obj != null && obj instanceof LoginBean) {
                                                    loginBean = (LoginBean) obj;
                                                }

                                                String case_id = request.getParameter("id");

                    %>
                    <h2 class="title">Set Penalty :</h2>
                    <form name="form1" id="form1" method="post" action="SetPanalty?id=<%=case_id%>&type=<%=loginBean.getUserType()%>">
                        <ul id="form_fields"><li>
                            <li><strong>Penalty Amount:</strong></li>
                            <li> <input type="text" name="atm" id="atm" onKeyDown="return isNumber(event)" required /></li>
                            <li><strong>Penalty Status:</strong></li>
                            <li><input type="text" value="pay" name="status" id="status"  onKeyDown="return isLetters(event)" required /> </li>
                            <li><strong>Date:</strong></li>

                            <li><input type="text" name="datepicker" id="datepicker" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit"  value="Submit"  style="margin-right:0px; margin-top:0px; width:60px; height:35px;background-image:url(images/Button.png);color: white"/></li>

                        </ul>
                    </form>
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