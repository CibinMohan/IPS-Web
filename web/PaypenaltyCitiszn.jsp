<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Pay Penalty</title>
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
                        id: {
                            required: true

                        },
                        number: {
                            required: true,
                            minlength: 12,
                            maxlength:12

                        },
                        bank: {
                            required: true,
                            minlength: 2,
                            digits:false


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
                    String status = request.getParameter("status");
                    if (status != null && !status.equals("") && status.equals("true")) {
        %>
        <h1 style="color: red" ><center>Payment Success, Case Closed... </center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("false")) {%>
        <h1 style="color: red"><center>Case already closed... </center></h1>
        <%} else if (status != null && !status.equals("") && status.equals("no")) {%>
        <h1 style="color: red"><center>Payment Failed...</center></h1>
        <%}%>
        <div class="body1"></div>
        <div class="body2">
            <div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li id="menu_active"><a href="index.jsp">Home</a></li>
                                <li><a href="aboutus.jsp">About Us</a></li>
                                <li><a href="services.jsp">Services</a></li>
                                <li class="bg_none"><a href="contacts.jsp">Contacts</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p><span class="marg_top">A traffic policeman in uniform has the right to
                                    demand your driver's license and inspect your vehicle's documents.
                                    He may impound your license if he feels to judge it necessary.Do not
                                    argue with the policeman. If you feel there is a genuine argument for
                                    you breaking a rule, explain it to him.</span>
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
                    <form name="form1" id="form1" method="post" action="CitizenPeyPenalty">
                        <ul id="form_fields"><li>
                            <li><strong>Case Id :</strong></li>
                            <li><input type="text" name="id" id=id" onKeyDown="return isNumber(event)" required />
                                <div id="apDiv3" style="background-image:url(images/pay_or_play1.jpg)"></div>
                            </li>
                            <li><strong>Bank Name :</strong></li>
                            <li><input type="text" name="bank" id="bank" onKeyDown="return isLetters(event)" required/></li>

                            <li><strong>Account Number :</strong></li>
                            <li><input type="text" name="number" id="number" onKeyDown="return isNumber(event)" required/></li>

                            <li></li>
                            <li></li>
                            <li>&nbsp; </li>
                            <li ><input type="submit" name="submit"  value="Submit"  style="margin-right:0px; margin-top:0px; width:60px; height:35px;background-image:url(images/Button.png); color: white"/></li>
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
</body>
</html>