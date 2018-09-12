//package cena;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/**
 *
 * @author siabr
 */
public class Cena implements GLEventListener, KeyListener{
    
    boolean flag = false;
    private float angulo;
    
    private float x;
    private float y;
    private float z;
    
    private float scalaX;
    private float scalaY;
    private float scalaZ;
    
    private float eixoX;
    private float eixoY;
    private float eixoZ;
    
    @Override
    public void init(GLAutoDrawable drawable) {
        //dados iniciais da cena
        x =0;
        y =0;
        z =0;
        
        angulo = 0;
        eixoX = 1;
        eixoY = 1;
        eixoZ = 1;
        
        scalaX = 1;
        scalaY = 1;
        scalaZ = 0;
    }

    @Override
    public void display(GLAutoDrawable drawable) {          
        drawQuads(drawable);
    }
    
    public void drawQuads(GLAutoDrawable drawable){
            //obtem o contexto Opengl
        GL2 gl = drawable.getGL().getGL2();                
        //define a cor da janela (R, G, G, alpha)
        gl.glClearColor(1, 1, 1, 1);        
        //limpa a janela com a cor especificada
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);       
        gl.glLoadIdentity(); //lÃª a matriz identidade
        
        /*
            desenho da cena        
        */
        gl.glColor3f(0,0,0); //cor RGB      
        //translate
        gl.glTranslatef( x ,  y , z );
        //scala
        gl.glScalef( scalaX,  scalaY,  scalaZ );
        //rotação
        gl.glRotatef( angulo , eixoX , eixoY , eixoZ);


        //desenha um quadrado
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(-0.5f, -0.5f);
            gl.glVertex2f(0.5f, -0.5f);
            gl.glVertex2f(0.5f, 0.5f);
            gl.glVertex2f(-0.5f, 0.5f);
        gl.glEnd();    

        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {    
        //obtem o contexto grafico Opengl
        GL2 gl = drawable.getGL().getGL2();        
        //ativa a matriz de projeção
        gl.glMatrixMode(GL2.GL_PROJECTION);      
        gl.glLoadIdentity(); //lê a matriz identidade
        //projeção ortogonal (xMin, xMax, yMin, yMax, zMin, zMax)
        gl.glOrtho(-1,1,-1,1,-1,1);
        //ativa a matriz de modelagem
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        System.out.println("Reshape: " + width + ", " + height);
    }    
       
    @Override
    public void dispose(GLAutoDrawable drawable) {}        

    @Override
    public void keyPressed(KeyEvent e) {         
        switch(e.getKeyChar()){
            case 'T':
                x += 0.1f;
                y += 0.1f;
                break;
            case 't':
                x -= 0.1f;
                y -= 0.1f;
                break;
            case 'r':
                angulo += 45;
                break;
            case 'E':
                scalaX += 0.1f;
                scalaY += 0.1f;
                break;
            case 'e':
                scalaX -= 0.1f;
                scalaY -= 0.1f;
                break;
                
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
