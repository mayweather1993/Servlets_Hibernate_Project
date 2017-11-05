package net.mayweather.dao;

import net.mayweather.model.Manufacturer;

import java.util.UUID;

public interface ManufacturerDAO extends GenericDAO<Manufacturer, UUID> {
    Manufacturer getByName(String name);
}
