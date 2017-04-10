<%@page import="com.ips.bean.CaseBean"%>
<%@page import="com.ips.manager.CaseManager"%>
<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Reset Penalty</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.4.2.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>
        <script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
        <!--[if lt IE 9]>
        <script type="text/javascript" src="js/ie6_script_other.js"></script>
        <script type="text/javascript" src="js/html5.js"></script>
        <![endif]-->
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
                            <p><span class="marg_top">The Police Act of 1909 officially broadened the Force's
                                    duties by stating that, in addition to those previously
                                    outlined, they were required to perform "all other duties"
                                    by an Act imposed on all peace officers.</span></p>
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
                    <%         loginBean = null;
                                                obj = session.getAttribute(AppConstants.USER_BEAN);
                                                if (obj != null && obj instanceof LoginBean) {
                                                    loginBean = (LoginBean) obj;
                                                }
                    %>
                    <%
                                                CaseBean caseBean = new CaseBean();
                                                String case_id = request.getParameter("id");
                                                if (!case_id.equals("") && case_id != null) {
                                                    CaseManager caseManager = new CaseManager();
                                                    caseBean = caseManager.getPayPenalty(case_id);
                                                }

                    %>
                    <h2 class="title">Re-Set Penalty :</h2>
                    <form name="form1" id="form1" method="post" action="ReSetPenalty?id=<%=case_id%>">
                        <ul id="form_fields"><li>
                            <li><strong>Suspect Name:</strong></li>
                            <li> <input type="text" name="name" id="name" value="<%=caseBean.getSuspect_Name()%>"/></li>
                            <li><strong>Penalty Amount:</strong></li>
                            <li> <input type="text" name="atm" id="atm" value="<%=caseBean.getPanalty_atm()%>" onKeyDown="return isNumber(event)" required  /></li>
                            <li><strong>Penalty Status:</strong></li>
                            <li><input type="text" name="status" id="status" value="<%=caseBean.getPanalty_status()%>" onKeyDown="return isLetters(event)" required /> </li>
                            <li><strong>Date:</strong></li>

                            <li><input type="text" name="datepicker" id="datepicker" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit"  value="Submit"  style="margin-right:0px; margin-top:0px; width:60px; height:35px; background-image:url(images/Button.png); color: white"/></li>

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