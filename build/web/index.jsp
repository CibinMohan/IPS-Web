<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS</title>
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
                width:317px;
                height:218px;
                z-index:3;
                left: 584px;
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
                        username: {
                            required: true                           
                        },
                        password: {
                            required: true                           
                        },                                                                                                                 
                        agree: "required"
                    },
                    messages: {
                        firstname: "Please enter your firstname",
                        lastname: "Please enter your lastname",
                        username: {
                            required: " \n Please enter a username"
                        },
                        password: {
                            required: "\n Please enter a password"
                        },                                              
                        email: "Please enter a valid email address",
                        agree: "Please accept our policy"
                    }
                });
            });
        </script>
    </head>
    <body id="page5">
        <%
                    String status = request.getParameter("status");
                    if (status != null && !status.equals("") && status.equals("false")) {
        %>
        <h1 style="color: red"><center>Login Failed, Retry...</center></h1>
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
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1"><b>IPS</b><span>of Scientific Thinking</span></div>
                            <p>Security police protect their agency's facilities, properties, personnel,
                                users, visitors and operations from harm and may enforce certain laws and
                                administrative regulations. Most security police have at least some arrest
                                authority. The law enforcement powers of security police vary widely, in
                                some cases limited to those of private persons yet in others amounting to
                                full police powers equivalent to state, provincial, or local law
                                enforcement.
                            </p>
                            <form name="form2" method="post" action="PaypenaltyCitiszn.jsp">
                                <blink>
                                    <input type="submit" name="pay" id="pay" value="Click here Pay Penalty" style="height:25px;width:200px;font:Georgia, 'Times New Roman', Times, serif; background-image:url(images/Button_1.png) ">
                                </blink>
                            </form>

                        </article>
                    </div>
                </header>
            </div>
        </div>      
        <div class="body3">
            <div class="main">
                <section id="content_top">
                    <article class="col1 pad_left2">
                        <ul class="list1">
                            <li> <span class="box1">1</span> <strong>A special welcome to the following
                                    Associations holding their Conferences at Police Security Expo 2013:
                            </li>
                            <li> <span class="box1">2</span> Government agencies that require security
                                services can contact Police Security Services Branch on (08) 8207 4008.</li>
                        </ul>
                    </article>
                </section>
            </div>
        </div>
        <div class="main">
            <section id="content">
                <div class="wrapper pad_bot1">
                    <article class="col1 pad_left2">
                        <h2>Real Security Experts</span></h2>
                        <p><strong>All security police derive their authority from two
                                sources: the laws of their nation, territory and/or
                                municipality the property rights of their employing or
                                contracting agency or activity, which may be public or
                                private or a mixture of both.These powers might include
                                the power to detain, arrest, investigate criminal
                                offenses, carry weapons, employ force, and/or take other
                                actions to protect life and property beyond that of the
                                ordinary citizen.
                        </p>
                    </article>
                    <div id="apDiv1">
                        <form id="form1" name="form1" method="post" action="LoginServlet">
                            <div class="third last">
                                <br/>
                                <ul id="form_fields">
                                    <li><strong> UserName:</strong></li>
                                    <li><input type="text" name="username" id="username" placeholder="Enter username" /> </li>
                                    <li style="margin-top:10px;"><strong> Password:</strong></li>
                                    <li><input type="password" name="password" id="password" placeholder="Enter password"/> </li>
                                    <li>&nbsp; </li>
                                    <li ><input type="submit" name="submit"  value="Login"  style="margin-right:0px; margin-top:0px; width:60px; height:35px; background-image:url(images/Button.png); color: white" /></li>
                                </ul>
                            </div>
                        </form>


                    </div>

                </div>


                <div class="wrapper">
                    <article class="col3">
                        <h3>POLICEMAN ACTION</h3>
                        <div class="pad">
                            <p class="pad_bot2"><strong> </strong></p>
                            <p>He may note down the particulars of your license which will later be forwarded
                                to a court. The court will then issue instructions regarding what course of action
                                is to be taken - a certain amount as fine. If you plead guilty and send the requisite
                                amount, the case will be filed.</p>
                        </div>
                    </article>
                    <article class="col3 pad_left1">
                        <h3>IMPORTANT OFFENSES</h3>
                        <div class="pad">
                            <ul class="list2 pad_bot1">
                                <li>Not carrying valid license while driving.</li>
                                <li>Driving under the influence of alcohol.</li>
                                <li>Moving against a One-way.</li>
                                <li>Improper use of headlights.</li>

                            </ul>
                        </div>
                    </article>
                    <article class="col3 pad_left1">
                        <h3>WHAT TODO & NOT</h3>
                        <div class="pad">
                            <p class="pad_bot2">Stop your vehicle when a traffic policeman so indicates.
                                You may ask him what the reason for your being stopped was.
                                Do not argue with the policeman. If you feel there is a
                                genuine argument for your having broken a rule, explain it to him.
                                If you have committed a mistake, admit it candidly, seek his pardon.
                            </p>
                        </div>
                    </article>
                </div>
                <div class="wrapper">
                    <article class="col3">

                    </article>
                    <article class="col3 pad_left1">

                    </article>
                    <article class="col3 pad_left1">

                    </article>
                </div>
            </section>
        </div>
        <div class="body4">
            <div class="main">
                <div id="footer_menu">
                    <nav>
                        <ul >
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="aboutus.jsp">About Us</a></li>
                            <li><a href="services.jsp">Services</a></li>
                            <li ><a href="contacts.jsp">Contacts</a></li>
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