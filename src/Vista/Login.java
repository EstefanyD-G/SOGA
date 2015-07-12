package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;

public class Login extends JFrame implements MouseListener, KeyListener, MouseMotionListener, ActionListener {

    static String tipoU;
    Negocio.UsuarioNg usuarioNg = new Negocio.UsuarioNg();
    JLabel jlbAirlineTravel;
    JLabel jlbLogin;
    JLabel jlbUsuario;
    JLabel jlbClave;
    JLabel jlb_x1, jlb_x2;
    JLabel jlbValidarC;
    JLabel jlbValidarP;
    JLabel jlbValidarCC;
    JLabel jlbValidarH;
    JLabel jlbNotiene;
    JLabel jlbsub;
    JLabel jlbRegistrate;
    JButton jbtnIngresar;
    JTextField jtxtUsuario;
    JTextField jtxtClave;
    String Clave;
    String Usuario;

    JPanel movedor;
    int x, y;

    public Login() {
        super.setTitle("Inicio");
        super.setSize(658, 450);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(585, 13, 25, 25);
        jlb_x1.setForeground(Color.DARK_GRAY);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(615, 5, 20, 40);
        jlb_x2.setForeground(Color.DARK_GRAY);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        //Titulo
        jlbAirlineTravel = new JLabel("");
        jlbAirlineTravel.setBounds(130, 18, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        movedor = new JPanel();
        movedor.setOpaque(false);
        movedor.setLayout(null);
        movedor.add(jlb_x1);
        movedor.add(jlb_x2);
        movedor.add(jlbAirlineTravel);
        movedor.setBounds(1, 1, 656, 60);
        movedor.addMouseListener(this);
        movedor.addMouseMotionListener(this);
        this.add(movedor);

        /*
        jlbLogin = new JLabel("Iniciar Sesión");
        jlbLogin.setBounds(80, 85, 250, 30);
        jlbLogin.setForeground(Color.WHITE);
        jlbLogin.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        this.add(jlbLogin);
        */        

        jlbUsuario = new JLabel("Nombre de Usuario");
        jlbUsuario.setBounds(40, 175, 160, 25);
        jlbUsuario.setForeground(Color.BLACK);
        jlbUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbUsuario);

        jtxtUsuario = new JTextField("estefany@hotmail.com");
        jtxtUsuario.setBounds(40, 200, 478, 30);
        jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtUsuario.addKeyListener(this);
        this.add(jtxtUsuario);

        jlbClave = new JLabel("Contraseña");
        jlbClave.setBounds(40, 265, 150, 25);
        jlbClave.setForeground(Color.BLACK);
        jlbClave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbClave);

        jtxtClave = new JPasswordField("estefany123");
        jtxtClave.setBounds(40, 290, 478, 30);
        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtClave.addKeyListener(this);
        this.add(jtxtClave);

        jbtnIngresar = new JButton("Iniciar Sesión");
        jbtnIngresar.setBorder(null);
        jbtnIngresar.setBounds(40, 340, 200, 35);
        jbtnIngresar.setBackground(Color.WHITE);
        jbtnIngresar.setForeground(Color.BLACK);
        jbtnIngresar.addActionListener(this);
        jbtnIngresar.addMouseListener(this);
        jbtnIngresar.setFocusPainted(false);
        jbtnIngresar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jbtnIngresar);

        jlbValidarC = new JLabel();
        jlbValidarC.setForeground(Color.RED);
        jlbValidarC.setBounds(40, 225, 250, 27);
        jlbValidarC.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarC.setVisible(false);
        this.add(jlbValidarC);

        jlbValidarP = new JLabel();
        jlbValidarP.setForeground(Color.RED);
        jlbValidarP.setBounds(40, 315, 250, 27);
        jlbValidarP.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarP.setVisible(false);
        this.add(jlbValidarP);

        jlbValidarCC = new JLabel("Por favor, asegúrese de escribir los datos correctamente");
        jlbValidarCC.setForeground(Color.RED);
        jlbValidarCC.setBounds(40, 400, 350, 27);
        jlbValidarCC.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarCC.setVisible(false);
        this.add(jlbValidarCC);

        jlbValidarH = new JLabel("¡Actualmente esta cuenta esta Inactiva!");
        jlbValidarH.setForeground(Color.RED);
        jlbValidarH.setBounds(40, 400, 250, 27);
        jlbValidarH.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarH.setVisible(false);
        this.add(jlbValidarH);       

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/fondo.png")));
        fondo.setBounds(0, 0, 658, 519);
        this.add(fondo);

        this.repaint();

    }

    public static void main(String[] args) {
        Login l = new Login();
    }

    public void actionPerformed(ActionEvent e) {

        boolean valido;
        String validoClave;
        UsuarioEnt usuarioE = new UsuarioEnt();
        UsuarioNg usuarioN = new UsuarioNg();

        if (e.getSource() == jbtnIngresar) {
            valido = validarCampos();
            int cont = 0, cont2 = 0;
            String usuario;
            usuario = jtxtUsuario.getText();
            usuarioE = usuarioN.buscarUsuario(usuario);
            if (valido) {

                for (int i = 0; i < usuario.length(); i++) {
                    if ("@".equals(usuario.substring(i, i + 1))) {
                        cont++;
                    }
                    if (cont == 1) {
                        if (".".equals(usuario.substring(i, i + 1))) {
                            cont2++;
                        }
                    }
                }

                if (cont != 1 || cont2 == 0) {
                    jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    jlbValidarC.setVisible(true);
                    jlbValidarP.setVisible(false);
                    jlbValidarC.setText("Ingrese una dirección de correo válida");
                    jlbValidarCC.setVisible(false);
                    jlbValidarH.setVisible(false);
                } else {
                    validoClave = usuarioNg.verificarUsuario(Usuario, Clave);
                    tipoU = validoClave;
                    if (validoClave != "none" && validoClave != "Inactivo") {
                        if (validoClave == "Pastor") {
                            Menu mi = new Menu();
                            mi.jlbNombre.setText("Bienvenido " + usuarioE.getNombre());
                            
                            this.setVisible(false);
                            this.dispose();
                        } else if (validoClave == "Miembro") {
                            Menu mi = new Menu();
                            mi.jlbNombre.setText("Bienvenido " + usuarioE.getNombre());

                            mi.jpUsuarios.jbtnActualizar.setBounds(0, 0, 0, 0);
                            mi.jpUsuarios.jbtnEliminar.setBounds(0, 0, 0, 0);

                            this.setVisible(false);
                            this.dispose();
                        } else if (validoClave == "Cliente") {
                            Menu mi = new Menu();
                            mi.jbtnUsuarios.setVisible(false);

                            mi.jlbNombre.setText("Bienvenido " + usuarioE.getNombre());

                            mi.Nombre = usuarioE.getNombre();

                            this.setVisible(false);
                            this.dispose();
                        }
                    } else {
                        if (validoClave == "Inactivo") {
                            Toolkit.getDefaultToolkit().beep();
                            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                            jlbValidarP.setVisible(false);
                            jlbValidarCC.setVisible(false);
                            jlbValidarC.setVisible(false);
                            jlbValidarH.setVisible(true);
                        }
                        if (validoClave == "none") {
                            Toolkit.getDefaultToolkit().beep();
                            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                            jlbValidarCC.setVisible(true);
                            jlbValidarC.setVisible(false);
                            jlbValidarH.setVisible(false);
                            jlbValidarP.setVisible(false);
                        }
                    }
                }
            }
        }
    }

    public boolean validarCampos() {

        boolean resp = true;

        Usuario = jtxtUsuario.getText();
        Clave = jtxtClave.getText();

        if (Usuario.trim().length() == 0 && Clave.trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jlbValidarC.setVisible(true);
            jlbValidarP.setVisible(true);
            jlbValidarC.setText("Ingrese el correo");
            jlbValidarP.setText("Ingrese la contraseña");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (Usuario.trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jlbValidarC.setVisible(true);
            jlbValidarP.setVisible(false);
            jlbValidarC.setText("Ingrese el correo");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (Clave.trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jlbValidarC.setVisible(false);
            jlbValidarP.setVisible(true);
            jlbValidarP.setText("Ingrese la contraseña");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (jtxtUsuario.getText().length() <= 10) {
            Toolkit.getDefaultToolkit().beep();
            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jlbValidarC.setVisible(true);
            jlbValidarP.setVisible(false);
            jlbValidarC.setText("El correo debe ser mayor que 10");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (jtxtClave.getText().length() <= 6) {
            Toolkit.getDefaultToolkit().beep();
            jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jlbValidarC.setVisible(false);
            jlbValidarP.setVisible(true);
            jlbValidarP.setText("La contraseña debe ser mayor que 6");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        return resp;

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == movedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnIngresar) {
            jbtnIngresar.setBackground(Color.WHITE);
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.DARK_GRAY);
        }
        if (arg0.getSource() == jlbRegistrate) {
            jlbRegistrate.setForeground(new Color(0, 154, 225));
            jlbsub.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnIngresar) {
            jbtnIngresar.setBackground(Color.WHITE);
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(255, 0, 0));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(255, 0, 0));
        }
        if (arg0.getSource() == jlbRegistrate) {
            jlbRegistrate.setForeground(Color.BLACK);
            jlbsub.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (e.getSource() == jlb_x2) {
            System.exit(0);
        }

        if (e.getSource() == jlbRegistrate) {
            this.setVisible(false);
            this.dispose();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == jtxtUsuario) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if ("null".equals(jtxtUsuario.getText().toLowerCase())) {
                jtxtUsuario.setText("");
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtClave) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if ("null".equals(jtxtClave.getText().toLowerCase())) {
                jtxtClave.setText("");
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

        if (ke.getSource() == jtxtUsuario) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtUsuario.getText().length() >= 30) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtClave) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtClave.getText().length() >= 20) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtUsuario) {
            if (jtxtUsuario.getText().length() <= 10) {
                jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtClave) {
            if (jtxtClave.getText().length() <= 6) {
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == movedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}
