package Unused;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

public interface PaintComponent extends ImageObserver, MenuContainer, Serializable, Accessible, WindowConstants, RootPaneContainer, ActionListener {
    void paintComponents(Graphics2D g);
}
