package bdv.workshop;

import bdv.util.Bdv;
import bdv.util.BdvFunctions;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import org.scijava.ui.behaviour.io.InputTriggerConfig;
import org.scijava.ui.behaviour.util.Actions;
import sc.fiji.simplifiedio.SimplifiedIO;

public class E04Actions
{
	/**
	 * Install custom keyboard shortcuts into a BDV window
	 */
	public static void main( final String[] args )
	{
		final Img< UnsignedByteType > img = SimplifiedIO.openImage(
				E04Actions.class.getResource( "/t1-head.tif" ).getFile(),
				new UnsignedByteType() );

		final Bdv bdv = BdvFunctions.show( img, "t1-head" );

		Actions actions = new Actions( new InputTriggerConfig() );
		actions.runnableAction(
				() -> System.out.println("ACTION!"),
				"my action",
				"shift A", "A" );
		actions.install( bdv.getBdvHandle().getKeybindings(), "my actions" );

//		bdv.getBdvHandle().getKeybindings().removeInputMap( "my actions" );
	}
}
