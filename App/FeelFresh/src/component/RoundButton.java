
package component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author lgpavithra
 */
public class RoundButton extends JButton {

    /**
     * @return the borderColorHex
     */
    public String getBorderColorHex() {
        return borderColorHex;
    }

    /**
     * @param borderColorHex the borderColorHex to set
     */
    public void setBorderColorHex(String borderColorHex) {
        this.borderColorHex = borderColorHex;
        customizing();
    }

    /**
     * @return the borderWidth
     */
    public String getBorderWidth() {
        return borderWidth;
    }

    /**
     * @param borderWidth the borderWidth to set
     */
    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth;
        customizing();
    }

    /**
     * @return the arc
     */
    public int getArc() {
        return arc;
    }

    /**
     * @param arc the arc to set
     */
    public void setArc(int arc) {
        this.arc = arc;
        customizing();

    }

    public RoundButton() {
        customizing();
    }

    private void customizing() {
        putClientProperty(FlatClientProperties.STYLE, "arc:" + arc + ";"
                + "borderColor:"+getBorderColorHex()+";"
                + "borderWidth:"+getBorderWidth()+";");
        
        SwingUtilities.updateComponentTreeUI(this);
    }

    
    private int arc = 40;
    private String borderColorHex = "#FFFFFF";
    private String borderWidth = "1";

}
