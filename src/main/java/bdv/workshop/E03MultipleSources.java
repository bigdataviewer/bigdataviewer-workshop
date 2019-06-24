package bdv.workshop;

import bdv.util.Bdv;
import bdv.util.BdvFunctions;
import bdv.util.BdvSource;
import bvv.util.Bvv;
import bvv.util.BvvFunctions;
import bvv.util.BvvSource;
import net.imglib2.RandomAccessible;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.ARGBType;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.view.Views;
import sc.fiji.simplifiedio.SimplifiedIO;

public class E03MultipleSources
{
	/*
	 * You can add more sources to an existing Bdv using Bdv.options().addTo(...)
	 */
	public static void main( final String[] args )
	{
		final Img< UnsignedByteType > img = SimplifiedIO.openImage(
				E01HelloWorld.class.getResource( "/t1-head.tif" ).getFile(),
				new UnsignedByteType() );

		final BdvSource source = BdvFunctions.show( img, "t1-head" );

		/*
		 * BdvSource implements Bdv.
		 * You can add more sources to an existing Bdv like this:
		 */
		final BdvSource source2 = BdvFunctions.show( img, "another head", Bdv.options()
				.addTo( source )
				.sourceTransform( 1.2, 1.2, 1.2 )
		);

		source.setColor( new ARGBType( 0xff00ff00 ) );
		source2.setColor( new ARGBType( 0xffff0000 ) );

		/*
		 * There are many variants of BdvFunctions.show(...)
		 *
		 * Here, we show an unbounded RandomAccessible.
		 */
//		final RandomAccessible< UnsignedByteType > infinite = Views.extendPeriodic( img );
//		final BdvSource source3 = BdvFunctions.show(
//				infinite, // infinite image
//				img, // just the interval to show in overview box
//				"infinite heads", Bdv.options().addTo( source ) );
//		source3.setColor( new ARGBType( 0xff0000ff ) );
	}
}
