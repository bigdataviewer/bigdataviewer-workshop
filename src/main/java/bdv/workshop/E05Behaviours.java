package bdv.workshop;

import bdv.util.Bdv;
import bdv.util.BdvFunctions;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import org.scijava.ui.behaviour.DragBehaviour;
import org.scijava.ui.behaviour.io.InputTriggerConfig;
import org.scijava.ui.behaviour.util.Behaviours;
import sc.fiji.simplifiedio.SimplifiedIO;

public class E05Behaviours
{
	/**
	 * Install custom keyboard and mouse actions into a BDV window
	 *
	 * See https://github.com/scijava/ui-behaviour/wiki/InputTrigger-syntax
	 */
	public static void main( final String[] args )
	{
		final Img< UnsignedByteType > img = SimplifiedIO.openImage(
				E05Behaviours.class.getResource( "/t1-head.tif" ).getFile(),
				new UnsignedByteType() );

		final Bdv bdv = BdvFunctions.show( img, "t1-head" );

		Behaviours behaviours = new Behaviours( new InputTriggerConfig() );
		behaviours.behaviour(
				new DragBehaviour()
				{
					@Override
					public void init( final int x, final int y )
					{
						System.out.println( "init x = [" + x + "], y = [" + y + "]" );
					}

					@Override
					public void drag( final int x, final int y )
					{
						System.out.println( "drag x = [" + x + "], y = [" + y + "]" );
					}

					@Override
					public void end( final int x, final int y )
					{
						System.out.println( "end x = [" + x + "], y = [" + y + "]" );
					}
				},
				"my behaviour",
				"meta button1", "A" );
		behaviours.install( bdv.getBdvHandle().getTriggerbindings(), "my behaviours" );

//		bdv.getBdvHandle().getKeybindings().removeInputMap( "my actions" );
	}
}
