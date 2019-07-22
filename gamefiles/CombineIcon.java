/*******************************************************************************
Filename: CombineIcon.java
@author: Timothy Bomers and Ryan Hilbert
@version 1.0
Due Date: 07-22-2019
Instructor: Dr. Jag Nandigam
Description: This class extends the Icon class and allows our icons to overlap
Code taken and changed from:
https://stackoverflow.com/questions/16299517/setting-multiple-icons-on-jbutton
*******************************************************************************/
package gamefiles;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/****************************************************************.
 * Class for combining icons for the game
*****************************************************************/
public class CombineIcon implements Icon {

	/**.
     * The top icon
     **/
	private Icon top;
	/**.
     * The bottom icon
     **/
	private Icon bot;
	
	/**.
     * Combines two given icons
     * @param top the icon to go on top
     * @param bottom the icon to go on bottom
     **/
    public CombineIcon(final Icon top, final Icon bottom) {
        this.top = top;
        this.bot = bottom;
    }

    /**.
     * Combines two given icons
     * @param none
     * @return the max height
     **/
    public int getIconHeight() {
        return Math.max(top.getIconHeight(), bot.getIconHeight());
    }

    /**.
     * Combines two given icons
     * @param none
     * @return the max width
     **/
    public int getIconWidth() {
        return Math.max(top.getIconWidth(), bot.getIconWidth());
    }

    /**.
     * Combines two given icons
     * @param c the component to be used as the observer
     * @param g the graphics context
     * @param x the top left x coordinate
     * @param y the top left y coordinate
     **/
    public void paintIcon(final Component c, final Graphics g, 
    		final int x, final int y) {
        bot.paintIcon(c, g, x, y);
        top.paintIcon(c, g, x, y);
    }

}
