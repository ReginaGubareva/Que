<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-16">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Que</title>

        <link rel="stylesheet" href="../../css/style.css" >

        <!-- Bootstrap CSS -->
        <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              rel="stylesheet">

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script crossorigin="anonymous"
                integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
                src="https://code.jquery.com/jquery-3.4.0.js"></script>
        <script crossorigin="anonymous"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script crossorigin="anonymous"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>

    <#include "navbar.ftl">
    <main role="main" class="container mx-auto justify-align-center inner cover">
        <div class="pageBody my-5 mx-auto">
            <#nested>
        </div>
    </main>
    </body>
    </html>

    <nav id="bottomNavbar" class="navbar fixed-bottom d-flex justify-content-around">
        <div class=" d-flex justify-content-around">
            <img class="mt-2" style="width: 60px; height: 60px;" src="../../images/kit.png">
            <div class="developedBy ml-4 mt-3">
                <p>© Developed by Gubareva R. Designed by Gubarev A. Logo of Yelikova K.
                    <br>
                    <a href="http://tarsu.kz/en/" style="color:#1BA0B6">TarSU 2019</a>
                </p>
            </div>
        </div>
        <div class="contacts">
            <p><strong>Contacts:</strong><br>
                rengubareva@gmail.com
                <br>
                artem.gbrev@gmail.com
                <br>
                ksyusha1404@gmail.com</p>
        </div>

    </nav>
</#macro>