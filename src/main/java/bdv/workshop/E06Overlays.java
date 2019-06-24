package bdv.workshop;

import bdv.util.Bdv;
import bdv.util.BdvFunctions;
import bdv.util.BdvOverlay;
import bdv.util.BdvSource;
import java.awt.Color;
import java.awt.Graphics2D;
import net.imglib2.img.Img;
import net.imglib2.realtransform.AffineTransform2D;
import net.imglib2.realtransform.AffineTransform3D;
import net.imglib2.type.numeric.ARGBType;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import org.scijava.ui.behaviour.DragBehaviour;
import org.scijava.ui.behaviour.io.InputTriggerConfig;
import org.scijava.ui.behaviour.util.Behaviours;
import sc.fiji.simplifiedio.SimplifiedIO;

public class E06Overlays
{
	/**
	 * Adding a BdvOverlay.
	 */
	public static void main( final String[] args )
	{
		final Img< ARGBType > img = SimplifiedIO.openImage(
				E02BdvOptions.class.getResource( "/clown.png" ).getFile(),
				new ARGBType() );

		final Bdv bdv = BdvFunctions.show( img, "clown", Bdv.options().is2D() );

		final BdvOverlay overlay = new BdvOverlay()
		{
			@Override
			protected void draw( final Graphics2D g )
			{
				g.setColor( Color.RED );
				final double[] p0 = { 50, 50 };
				final double[] p1 = { 350, 350 };
				g.drawLine(
						( int ) p0[ 0 ],
						( int ) p0[ 1 ],
						( int ) p1[ 0 ],
						( int ) p1[ 1 ] );

				/*
				 * The BdvOverlay super class provides methods to get the current transformation.
				 */
//				AffineTransform2D transform = new AffineTransform2D();
//				this.getCurrentTransform2D( transform );
//
//				final double[] p0t = new double[ 2 ];
//				final double[] p1t = new double[ 2 ];
//				transform.apply( p0, p0t );
//				transform.apply( p1, p1t );
//				g.setColor( Color.GREEN );
//				g.drawLine(
//						( int ) p0t[ 0 ],
//						( int ) p0t[ 1 ],
//						( int ) p1t[ 0 ],
//						( int ) p1t[ 1 ] );

				/*
				 * Overlays are added as fake sources, so their color, brightness, visibility can be modified through the UI.
				 * The BdvOverlay super class has a field "info" that provides access to those properties.
				 */
//				g.setColor( new Color( info.getColor().get() ) );
			}
		};

		BdvFunctions.showOverlay( overlay, "overlay", Bdv.options().addTo( bdv ) );
	}
}
