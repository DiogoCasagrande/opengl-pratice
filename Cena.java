import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListner;

public class Cena implements GLEventListener, KeyListener{
	private float x =;
	
	@Override
	public void init(GLAutoDrawable drawable){

	}

	@OVerride
	public void display(GLAutoDrawable drawable){
		//obter o contexto OPENGL
		GL2 gl = drawable.getGL().getGL2();
		//define a cor da janela (R,G,G, alpho)
		gl.glClearColor(1,0,0,1);
		//limpa a janela com a cor especifica
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glLoadIdentity(); //le a matriz identidade
		

		/* 
		 * desenho da cena 
		*/
		gl.glColor3f(0,1,9);//cor verde

		//desenha um retangulo

	}
}
