package com.company.demo.web.client;

import com.company.demo.entity.Client;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.DataGrid.ColumnGenerator;
import com.haulmont.cuba.gui.components.DataGrid.ComponentRenderer;
import com.haulmont.cuba.gui.icons.CubaIcon;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.theme.HaloTheme;

import javax.inject.Inject;

@UiController("demo_ClientList")
@UiDescriptor("client-list.xml")
@LoadDataBeforeShow
public class ClientList extends Screen {
    @Inject
    protected DataGrid<Client> clientsDataGrid;
    @Inject
    protected UiComponents uiComponents;

    @Subscribe
    protected void onInit(InitEvent event) {
        clientsDataGrid
                .addGeneratedColumn("generatedCell", new ColumnGenerator<Client, Component>() {
                    @Override
                    public Component getValue(DataGrid.ColumnGeneratorEvent<Client> event) {
                        return generateClientRow(event.getItem());
                    }

                    @Override
                    public Class<Component> getType() {
                        return Component.class;
                    }
                })
                .setRenderer(clientsDataGrid.createRenderer(ComponentRenderer.class));
    }

    private Component generateClientRow(Client client) {
        VBoxLayout dataBox = uiComponents.create(VBoxLayout.class);
        dataBox.setSpacing(true);

        Label<String> titleLabel = uiComponents.create(Label.NAME);
        titleLabel.setWidthFull();
        titleLabel.setStyleName(HaloTheme.LABEL_H2);
        titleLabel.setValue(client.getTitle());

        Label<String> addressLabel = uiComponents.create(Label.NAME);
        addressLabel.setWidthFull();
        addressLabel.setValue(client.getAddress());

        dataBox.add(titleLabel, addressLabel);

        HBoxLayout mainBox = uiComponents.create(HBoxLayout.class);
        mainBox.setWidthFull();

        mainBox.add(dataBox);
        mainBox.expand(dataBox);

        Button button = uiComponents.create(Button.class);
        button.setAlignment(Component.Alignment.MIDDLE_RIGHT);
        button.setDescription("Remove");
        button.setIconFromSet(CubaIcon.REMOVE);
        button.addClickListener(clickEvent -> {
            // remove client here
        });

        mainBox.add(button);

        return mainBox;
    }
}