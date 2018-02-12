package dao;

import model.Manufacturer;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.UUID;

public interface ManufacturerDAO extends GenericDAO<Manufacturer, UUID> {

}
