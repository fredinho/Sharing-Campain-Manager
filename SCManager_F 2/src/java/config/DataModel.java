/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author FREDINHO
 */
import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;


public class DataModel extends ListDataModel implements SelectableDataModel,Serializable {
    public DataModel() {
    }

    public DataModel(List data) {
        super(data);
    }

    @Override
    public Object getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  

        List<Object> Objects = (List<Object>) getWrappedData();

        for (Object Object : Objects) {
           /* if (Object.getModel().equals(rowKey)) {
                return Object;
            }*/
        }

        return null;
    }

    @Override
    public Object getRowKey(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
