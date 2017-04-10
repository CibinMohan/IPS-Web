<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Case Registration</title>
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
                width:440px;
                height:485px;
                z-index:3;
                left: 372px;
                top: -11px;
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
                            minlength: 2,
                            digits:false
                        },
                        username: {
                            required: true,
                            minlength: 2,
                            remote:'AjaxServlet1'

                        },
                        password: {
                            required: true,
                            minlength: 5
                        },
                        conpassword: {
                            required: true,
                            minlength: 5,
                            equalTo: "#password"
                        },
                        email: {
                            required: true,
                            email: true
                        },
                        phone: {
                            required: true,
                            minlength: 10,
                            digits:true,
                            maxlength:10

                        },
                        number: {
                            required: true,
                            minlength: 4,                            
                            maxlength:6

                        },
                        topic: {
                            required: "#newsletter:checked",
                            minlength: 2
                        },
                        address: {
                            required: true,
                            minlength: 15
                        },
                        agree: "required"
                    },
                    messages: {
                        firstname: "Please enter your firstname",
                        lastname: "Please enter your lastname",
                        username: {
                            required: "Please enter a username",
                            minlength: "Your username must consist of at least 2 characters"
                        },
                        password: {
                            required: "Please provide a password",
                            minlength: "Your password must be atleast 5 characters long"
                        },
                        conpassword: {
                            required: "Please provide a password",
                            minlength: "Your password must be atleast 5 characters long",
                            equalTo: "Please enter the same password as above"
                        },
                        phone: {
                            required: "Please provide a phone number",
                            minlength: "minimum length 10 digits",
                            digits: "Please enter only digits.",
                            maxlength:"maximum length 10 digits"

                        },
                        email: "Please enter a valid email address",
                        agree: "Please accept our policy"
                    }
                });
            });
            function isLetters(evt) {
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;

                if (charCode > 32 && (charCode < 37 || charCode > 40) && (charCode < 46 || charCode > 46) &&
                    (charCode < 65 || charCode > 90) && (charCode != 190) ) {
                    return false;
                }
                return true;
            }
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
        <%
                                    String status = request.getParameter("status");
                                    if (status != null && !status.equals("") && status.equals("true")) {
        %>
        <h1 style="color: red"><center>Case Registered Successfully...</center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("false")) {%>
        <h1 style="color: red"><center>Case Registration Failed...</center></h1>
        <%}%>


        <div class="body1"></div>
        <div class="body2">
            <div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li><a href="Police.jsp">Home</a></li>
                                <li id="menu_active" class="bg_none">
                                    <a href="CaseRegistration.jsp">Add Cases </a></li>
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
                            <p>The police have all sorts of different powers, all of which are given by
                                law and they must use them only according to the procedure laid down in the law.
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
                        <h2>Miscellaneous Info:</h2>
                        <p class="marg_top">Traffic regulation enforcement has mostly concentrated to date on
                            the important problems of speeding, alcohol impairment and failure to use seat
                            belts. At the same time, there are other important offences in road safety terms
                            which have yet to be included as priority areas in police work.
                        </p>
                    </article>
                </section>
            </div>
        </div>
        <div class="main">
            <section id="content">
                <article class="pad_left2">
                    <h2 class="title"> New Case Registration:</h2>
                    <form name="form1" id="form1" method="post" action="CaseRegistrationServlet">
                        <ul id="form_fields">
                            <li><strong>Owner Name:</strong></li>
                            <li>
                                <input type="text" name="name" id="name" onKeyDown="return isLetters(event)" required/>
                            </li>
                            <li><strong>Vehicle No:</strong></li>
                            <li><input type="text" name="number" id="number" /> </li>
                            <li><strong> Email:</strong></li>
                            <li><input type="text" name="email" id="email" /> </li>
                            <li><strong> Phone:</strong></li>
                            <li><input type="text" name="phone" id="phone" onKeyDown="return isNumber(event)" required/></li>

                            <li></li>
                            <li>&nbsp; </li>
                            <li ><input type="submit" name="submit"  value="Submit"  style="margin-right:0px; margin-top:0px; width:60px; height:35px; background-image:url(images/Button.png);color: white"/></li>
                            <li ></li>
                            <li ></li>
                        </ul>
                </article>
            </section>
        </div>
        <div class="body4">
            <div class="main">
                <div id="footer_menu">
                    <nav>
                        <ul>
                            <li><a href="Police.jsp">Home</a></li>
                            <li><a href="CaseRegistration.jsp">Add Cases</a></li>
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