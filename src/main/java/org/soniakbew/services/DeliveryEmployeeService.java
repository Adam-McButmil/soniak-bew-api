package org.soniakbew.services;
import org.soniakbew.daos.DeliveryEmployeeDao;
import org.soniakbew.exceptions.DoesNotExistException;
import org.soniakbew.exceptions.Entity;
import org.soniakbew.models.DeliveryEmployee;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {
    private final DeliveryEmployeeDao deliveryEmployeeDao;
    public DeliveryEmployeeService(
            final DeliveryEmployeeDao deliveryEmployeeDao
    ) {
        this.deliveryEmployeeDao = deliveryEmployeeDao;
    }
    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        return deliveryEmployeeDao.getAllDeliveryEmployees();
    }
    public DeliveryEmployee getDeliveryEmployeeById(final int id)
            throws SQLException {
        return deliveryEmployeeDao.getDeliveryEmployeeById(id);
    }

    public void deleteDeliveryEmployee(final int id) throws SQLException,
            DoesNotExistException {
        DeliveryEmployee deliveryEmployee =
                deliveryEmployeeDao.getDeliveryEmployeeById(id);
        if (deliveryEmployee == null) {
            throw new DoesNotExistException(Entity.DELIVERY_EMPLOYEE);
        }
        deliveryEmployeeDao.deleteDeliveryEmployee(id);
    }
}
