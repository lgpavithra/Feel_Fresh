/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

/**
 *
 * @author senad
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AutoCompleteComboBox extends JComboBox{

    private List<String> items;

    public AutoCompleteComboBox(String[] items) {
        super(items);
        this.items = new ArrayList<>(List.of(items));
        setEditable(true);

        JTextField textField = (JTextField) getEditor().getEditorComponent();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = textField.getText();
                if (input.length() == 0) {
                    // Reset to original items when input is empty
                    setModel(new DefaultComboBoxModel<>(items));
                    return;
                }

                List<String> filteredItems = new ArrayList<>();
                for (String item : items) {
                    if (item.toLowerCase().startsWith(input.toLowerCase())) {
                        filteredItems.add(item);
                    }
                }

                // Update model with filtered items
                setModel(new DefaultComboBoxModel<>(filteredItems.toArray(new String[0])));
                textField.setText(input); // Keep the current input in the text field
                showPopup(); // Show dropdown with filtered items
            }
        });
    }
}
