package bdv.workshop;

import bdv.util.BdvFunctions;
import bdv.util.BdvSource;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import sc.fiji.simplifiedio.SimplifiedIO;

public class E01HelloWorld
{
	/**
	 * Show an image in BigDataViewer.
	 */
	public static void main( final String[] args )
	{
		final Img< UnsignedByteType > img = SimplifiedIO.openImage(
				E01HelloWorld.class.getResource( "/t1-head.tif" ).getFile(),
				new UnsignedByteType() );

		final BdvSource source = BdvFunctions.show( img, "t1-head" );

		/*
		 * BdvSource is a handle that can be used to set color, display range, visibility, ...
		 */
//		source.setDisplayRange( 0, 555 );
//		source.setColor( new ARGBType( 0xff00ff00 ) );
	}
}
