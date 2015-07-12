package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;
import Vista.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    JLabel jlbAirlineTravel, cancelar;
    JLabel jlbNombre, jlbCorreo, jlbimage;
    JLabel jlb_x1, jlb_x2;

    JButton jbtnInicio;
    JButton jbtnUsuarios;
  //JButton jbtnEventos;
    JButton jbtnCerrarSesion;
  //JButton jbtnGuardar;

    JPanel jpMovedor, jpInicio;

    Usuarios jpUsuarios = new Usuarios();
  //Eventos jpEventos = new Eventos();

    String Correo, Clave, Nombre, Apellido, Telefono, Celular;

    int x, y;
    Color a = Color.GRAY;
    Color b = Color.DARK_GRAY;
    Color c = Color.DARK_GRAY;
    Color d = Color.DARK_GRAY;
    Color e = Color.DARK_GRAY;
    Color f = Color.DARK_GRAY;
    Color g = Color.DARK_GRAY;
    Color h = Color.DARK_GRAY;
    Color i = Color.DARK_GRAY;

    MenuItem aboutItem, ayuda;
    MenuItem exitItem, exitItem2;
    MenuItem errorItem;
    MenuItem warningItem;
    MenuItem infoItem;
    MenuItem noneItem;
    PopupMenu displayMenu;

    ImageIcon image = new ImageIcon();

    PopupMenu popup = new PopupMenu();
    TrayIcon trayIcon = new TrayIcon(createImage("/Imagenes/icono.png", "tray icon"));
    SystemTray tray = SystemTray.getSystemTray();

    public Menu() {
        super.setTitle("Menu");
        super.setSize(882, 600);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(809, 15, 25, 25);
        jlb_x1.setForeground(Color.WHITE);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(839, 10, 20, 30);
        jlb_x2.setForeground(Color.WHITE);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jlbAirlineTravel = new JLabel("");
        jlbAirlineTravel.setBounds(290, 18, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        //Inicio Menu
        jbtnCerrarSesion = new JButton(" Cerrar Sesión");
        jbtnCerrarSesion.setBounds(240, 0, 120, 61);
        jbtnCerrarSesion.setBorder(null);
        jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        jbtnCerrarSesion.setForeground(Color.WHITE);
        jbtnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnCerrarSesion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCerrarSesion.addMouseListener(this);
        jbtnCerrarSesion.addActionListener(this);
        jbtnCerrarSesion.setFocusPainted(false);
        this.add(jbtnCerrarSesion);
        
        /*
        jbtnEventos = new JButton(" Eventos");
        jbtnEventos.setBounds(240, 0, 120, 61);
        jbtnEventos.setBorder(null);
        jbtnEventos.setBackground(b);
        jbtnEventos.setForeground(Color.WHITE);
        jbtnEventos.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnEventos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEventos.addMouseListener(this);
        jbtnEventos.setFocusPainted(false);
        this.add(jbtnEventos);
        */
        
        jbtnUsuarios = new JButton(" Usuarios");
        jbtnUsuarios.setBounds(120, 0, 120, 61);
        jbtnUsuarios.setBorder(null);
        jbtnUsuarios.setBackground(b);
        jbtnUsuarios.setForeground(Color.WHITE);
        jbtnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnUsuarios.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnUsuarios.addMouseListener(this);
        jbtnUsuarios.setFocusPainted(false);
        this.add(jbtnUsuarios);
        
        jbtnInicio = new JButton(" Inicio");
        jbtnInicio.setBounds(0, 0, 120, 61);
        jbtnInicio.setBorder(null);
        jbtnInicio.setBackground(a);
        jbtnInicio.setForeground(Color.WHITE);
        jbtnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnInicio.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnInicio.addMouseListener(this);
        jbtnInicio.setFocusPainted(false);
        this.add(jbtnInicio);
        //Fin Menu

        JPanel jpBotones = new JPanel();
        jpBotones.setBackground(Color.DARK_GRAY);
        jpBotones.add(jbtnInicio);
        jpBotones.add(jbtnUsuarios);
      //jpBotones.add(jbtnEventos);
        jpBotones.add(jbtnCerrarSesion);
        jpBotones.setLayout(null);
        jpBotones.setBounds(0, 0, 882, 61);
        this.add(jpBotones);

        

        //Nombre
        jlbNombre = new JLabel("");
        jlbNombre.setBounds(0, 0, 500, 30);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(jlbNombre);
        //Correo
        jlbCorreo = new JLabel("");
        jlbCorreo.setBounds(0, 0, 0, 0);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(jlbCorreo);
        //Imagen
        jlbimage = new JLabel("");
        jlbimage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jlbimage.setBounds(0, 0, 0, 0);
        this.add(jlbimage);

        JLabel fondoI = new JLabel();
        fondoI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/walker-fondo.png")));
        fondoI.setBounds(0, 0, 700, 538);
        this.add(fondoI);

        jpInicio = new JPanel();
        jpInicio.setOpaque(false);
        jpInicio.setLayout(null);
        jpInicio.add(jlbNombre);
        jpInicio.add(jlbCorreo);
        jpInicio.add(jlbimage);
        jpInicio.add(fondoI);
        jpInicio.setBounds(50, 100, 882, 100);
        this.add(jpInicio);

        Container guardapaneles = getContentPane();
        guardapaneles.add(jpUsuarios);

        cancelar = new JLabel("Cancelar");
        cancelar.setBounds(250, 476, 57, 20);
        cancelar.setForeground(Color.DARK_GRAY);
        cancelar.addMouseListener(this);
        cancelar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jpUsuarios.add(cancelar);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/walker-fondo.png")));
        fondo.setBounds(0, 0, 882, 600);
        this.add(fondo);

        this.repaint();
    }

    public static void main(String[] args) {
        Menu m = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnCerrarSesion) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                Login l = new Login();
                this.dispose();
                tray.remove(trayIcon);
            }
        }
        if (e.getSource() == aboutItem) {
            this.setVisible(true);
        }
        if (e.getSource() == trayIcon) {
            this.setVisible(true);
        }

        if (e.getSource() == exitItem2) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                Login l = new Login();
                this.dispose();
                tray.remove(trayIcon);
            }
        }

        if (e.getSource() == exitItem) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro cerrar la aplicación?", "Cerrar Aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.YES_OPTION == i) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == jpMovedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(a);
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(b);
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        }
        
        
        /*
        if (arg0.getSource() == jbtnEventos){
            jbtnEventos.setBackground(Color.DARK_GRAY);
        }
        */
        
        if (arg0.getSource() == cancelar) {
            cancelar.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.WHITE);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(new Color(24, 25, 26));
        }
        
        /*
        if (arg0.getSource() == jbtnEventos){
            jbtnEventos.setBackground(new Color(24, 25, 26));
        }
        */

        if (arg0.getSource() == cancelar) {
            cancelar.setForeground(new Color(237, 28, 36));
        }
        
        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(255, 0, 0));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(255, 0, 0));
        }
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (ev.getSource() == jbtnInicio) {
            a = Color.GRAY;
            b = c = d = e = f = g = h = i = Color.DARK_GRAY;
            jbtnUsuarios.setBackground(b);
            jpInicio.setVisible(true);
            jpUsuarios.setVisible(false);
          //jpEventos.setVisible(false);
        }

        if (ev.getSource() == jbtnUsuarios) {
            b = Color.GRAY;
            a = c = d = e = f = g = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(true);

            jpUsuarios.LimpiarCampos();
            jpUsuarios.pnDatos.setVisible(false);
            jpUsuarios.jpBotones.setVisible(true);
            jpUsuarios.jpError.setVisible(true);

        }
        
        /*
        if (ev.getSource() == jbtnEventos) {
            b = Color.GRAY;
            a = c = d = e = f = g = h = i = Color.DARK_GRAY;
            jbtnEventos.setBackground(a);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(true);

            jpUsuarios.LimpiarCampos();
            jpUsuarios.pnDatos.setVisible(false);
            jpUsuarios.jpBotones.setVisible(true);
            jpUsuarios.jpError.setVisible(true);
        }
        */

        if (ev.getSource() == cancelar) {
            LimpiarCampos();
        }

        if (ev.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (ev.getSource() == jlb_x2) {
            trayIcon.displayMessage("Flight System", "Pasando a segundo plano...", TrayIcon.MessageType.INFO);
            super.setVisible(false);
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == jpMovedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    protected static Image createImage(String path, String description) {
        URL imageURL = Menu.class
                .getResource(path);

        if (imageURL
                == null) {
            System.err.println("Imagen no encontrada: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    public void goToURL(String URL) {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void LimpiarCampos() {
        
    }

}
