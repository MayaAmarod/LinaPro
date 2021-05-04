<%-- 
    Document   : MiprimerJsp
    Created on : 16/03/2021, 08:38:42 PM
    Author     : spier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%--    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>LINA - Inicio</title>
        <link rel="shortcut icon" href="Imagen/LogoLina.svg" type="image/x-icon">        
    </head>
    <link href="css/EstiloPagComercial.css" rel="stylesheet" type="text/css"/>    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&display=swap" rel="stylesheet"> 
    <body>
        <header>
            <div class="clogo">
                <img src="Imagen/LogoLina2.svg" alt="" class="logoinicial">
                </div>
            <nav>
                <%
                    String mensajeUS = (String) session.getAttribute("Usuario");
                %>  
                
                <a href="#">Inicio</a>
                <a href="#">Acerca de</a>
                <a href="#">Portafolio</a>
                <a href="#">Servicios</a>
                <a href="#">Contacto</a>
                 <a href="Login.jsp">Iniciar Sesión</a>

                
                            
            </nav>
            <section class="textos-header">
                <h1>Con Lina Podras</h1>
                <h2></h2>
            </section>
            <div class="wave" style="height: 150px; overflow: hidden;"><svg viewBox="0 0 500 150" preserveAspectRatio="none"
                                                                            style="height: 100%; width: 100%;">
                <path d="M0.00,49.98 C150.00,150.00 349.20,-50.00 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
                      style="stroke: none; fill: #fff;"></path>
                </svg></div>
        </header>
        <main>
            <section class="contenedor sobre-nosotros">
                <h2 class="titulo">Nuestro producto</h2>
                <div class="contenedor-sobre-nosotros">
                    <img src="Imagen/ilustracion5.svg" alt="" class="imagen-about-us">
                    <div class="contenido-textos">
                        <h3><span>1</span>Web + Aplicaciones</h3>
                        <p>Con nuestro sólido equipo de desarrolladores, diseñamos y creamos soluciones digitales que equilibren los objetivos de tu organización con las necesidades de tus usuarios.</p>
                        <h3><span>2</span>Contenidos Atrayentes</h3>
                        <p>              Te ayudaremos a encontrar tu voz y crear contenido atractivo para tu audiencia a través de historias, artículos y contenido social. Lorem ipsum dolor sit amet.</p>
                    </div>
                </div>
            </section>
            <section class="portafolio">
                <div class="contenedor">
                    <h2 class="titulo">Portafolio</h2>
                    <div class="galeria-port">
                        <div class="imagen-port">
                            <img src="Imagen/img1.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img2.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img3.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img1.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img4.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img5.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img6.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="Imagen/img7.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="Imagen/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="clientes contenedor">
                <h2 class="titulo">Que dicen nuestros clientes</h2>
                <div class="cards">
                    <div class="card">
                        <img src="Imagen/face1.jpg" alt="">
                        <div class="contenido-texto-card">
                            <h4>Laura Diaz</h4>
                            <p>Sin duda, el servicio que nos brinda LINA, nos ayuda a ser más eficientes y productivos. Ciertamente, la gestión realizada por ellos es más que sobresaliente.</p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="Imagen/face2.jpg" alt="">
                        <div class="contenido-texto-card">
                            <h4>Sofia Perez</h4>
                            <p>Sobre todo, nos han brindado asesoría y nos han prestado el servicio, que ha hecho que no tengamos problemas con nuestros procesos. Realmente saben lo que hacen.</p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="about-services">
                <div class="contenedor">
                    <h2 class="titulo">Nuestros servicios</h2>
                    <div class="servicio-cont">
                        <div class="servicio-ind">
                            <img src="Imagen/ilustracion1.svg" alt="">
                            <h3>AGILIZAR</h3>
                            <p>Agilizar porcesos de tu empresa</p>
                        </div>
                        <div class="servicio-ind">
                            <img src="Imagen/ilustracion3.svg" alt="">
                            <h3>MEJORAR</h3>
                            <p>Mejorar la productividad de tus empleados</p>
                        </div>
                        <div class="servicio-ind">
                            <img src="Imagen/ilustracion4.svg" alt="">
                            <h3>AUMENTAR</h3>
                            <p>Aumentar tus ganancias significativamente</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer>
            <div class="contenedor-footer">
                <div class="content-foo">
                    <h4>Telefono</h4>
                    <p>8296312</p>
                </div>
                <div class="content-foo">
                    <h4>Email</h4>
                    <p>Empresa@registrate.com.co</p>
                </div>
                <div class="content-foo">
                    <h4>Ubicacion</h4>
                    <p>**********</p>
                </div>
            </div>
            <h1 class="titulo-final">&copy; Privacy & Cookies Policy </h1>
        </footer>
    </body>
</html> 



