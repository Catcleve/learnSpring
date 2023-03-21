package com.example.applicationcontext.convert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class DatePropertyEditor extends PropertyEditorSupport implements PropertyEditorRegistrar {

    private String format;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (format == null) {
            format = "yyyy-MM-dd";
        }
        System.out.println("text = " + text);
        SimpleDateFormat format = new SimpleDateFormat(this.format);
        try {
            this.setValue(format.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, this);
    }


}
