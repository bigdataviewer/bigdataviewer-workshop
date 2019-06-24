package bdv.workshop;

import bdv.util.Bdv;
import bdv.util.BdvFunctions;
import bdv.util.BdvSource;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.ARGBType;
import sc.fiji.simplifiedio.SimplifiedIO;

public class E02BdvOptions
{
	/**
	 * Using Bdv.options()
	 */
	public static void main( final String[] args )
	{
		final Img< ARGBType > img = SimplifiedIO.openImage(
				E02BdvOptions.class.getResource( "/clown.png" ).getFile(),
				new ARGBType() );

		final BdvSource source = BdvFunctions.show( img, "clown",
				Bdv.options()
						.is2D()
//						.frameTitle( "Learnathon 2019" )
//						.sourceTransform( 1.0, 1.9 )
		);

		/*
		 * BdvSource is a handle that can be used to set color, display range, visibility, ...
		 */
//		source.setDisplayRange( 0, 555 );
//		source.setColor( new ARGBType( 0xff00ff00 ) );

		/*
		 * Multi-channel, time-series, etc work, but you have to explicitly specify
		 * calibration, axis order, etc...
		 */
//		final Img< UnsignedShortType > img2 = SimplifiedIO.openImage(
//				E02BdvOptions.class.getResource( "/mitosis.tif" ).getFile(),
//				new UnsignedShortType() );
//
//		final BdvStackSource< UnsignedShortType > mitosis = BdvFunctions.show( img2, "mitosis",
//				Bdv.options()
//						.axisOrder( AxisOrder.XYCZT )
//						.sourceTransform( 0.0885, 0.0885, 1.0 )
//		);

		/*
		 * The mitosis BdvSource is now actually multiple low-level sources (one for each channel).
		 * To set color etc for channels individually we have to dig deeper...
		 */
//		// setting the color and min/max of channel 0
//		mitosis.getConverterSetups().get( 0 ).setColor( new ARGBType( 0xffff0000 ) );
//		mitosis.getConverterSetups().get( 0 ).setDisplayRange( 1582, 11086 );
//
//		// setting the color and min/max of channel 1
//		mitosis.getConverterSetups().get( 1 ).setColor( new ARGBType( 0xff00ff00 ) );
//		mitosis.getConverterSetups().get( 1 ).setDisplayRange( 1614, 15787 );
	}
}
