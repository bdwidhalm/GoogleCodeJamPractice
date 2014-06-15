//import gps.directory.UserRegistry;
//import gps.directory.registry.RoleRegistry;
//import gps.logger.Timer;
//import gps.sos.model.Hardware;
//import gps.sos.registry.HardwareRegistry;
//import gps.sos.util.ConnectionUtil;
//import gps.util.database.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ConvertOldData
{
  /**
   * Takes data formatted in an old database (multiple rows per Hardware item
   * and moves it to a normalized database table with each row representing
   * a hardware item
   *
   *
   * @param connection
   */
  // DELETE AFTER CSV FILE IS CREATED!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//  private static void convertOldHardwareToCsv(Connection connection)
//  {
//    List<Hardware> returnValue = new ArrayList<Hardware>();
//
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//
//    Timer timer = new Timer(HardwareRegistry.class, "convertOldHardwareToCsv(Connection)");
//
//    try
//    {
//      // pull old hardware from old database table
//      String query = "SELECT * FROM  oldhw";
//
//      connection = ConnectionUtil.getConnection();
//      ps = connection.prepareStatement(query);
//      log.trace(ps);
//      rs = ps.executeQuery();
//
//      Hardware oldHardware = new Hardware();
//      List<Hardware> oldHardwareList = new ArrayList<Hardware>();
//
//      while (rs.next())
//      {
//        if (rs.getLong("id") != oldHardware.getId())
//        {
//          if (oldHardware.getId() != -1)
//          {
//            oldHardwareList.add(oldHardware);
//          }
//          oldHardware = new Hardware();
//          oldHardware.setId(rs.getLong("id"));
//        }
//
//
//        if (rs.getString("field_key").equals("Type of Equipment"))
//        {
//          oldHardware.setType(rs.getString("field_value"));
//        }
//        if (rs.getString("field_key").equals("Computer Type"))
//        {
//          oldHardware.setType(rs.getString("field_value"));
//        }
//        if (rs.getString("field_key").equals("Make and Model"))
//        {
//          oldHardware.setMakeModel(rs.getString("field_value"));
//        }
//        if (rs.getString("field_key").equals("Fixed Asset Number"))
//        {
//          oldHardware.setFixedAssetNumber(rs.getString("field_value"));
//          oldHardware.setCreated(rs.getTimestamp("created"));
//          oldHardware.setCreatedBy(RoleRegistry.getUser(rs.getString("createdBy")));
//          oldHardware.setModified(rs.getTimestamp("created"));
//          oldHardware.setModifiedBy(RoleRegistry.getUser(rs.getString("createdBy")));
//        }
//        if (rs.getString("field_key").equals("Serial Number"))
//        {
//          oldHardware.setSerialNumber(rs.getString("field_value"));
//        }
//      }
//
//      // save old hardware to new database table
//      String insertQuery = "INSERT INTO oldhwcsv SET id = ?, fixedAssetNumber = ?, serialNumber = ?, makeModelName = ?, " +
//          "hardwareType = ?, created = ?, createdBy = ?, modified = ?, modifiedBy = ?";
//      PreparedStatement psInsert = connection.prepareStatement(insertQuery);
//
//      for (Hardware hardware : oldHardwareList)
//      {
//          hardware.setCreated(new Date());
//          hardware.setCreatedBy(UserRegistry.getCurrentUser());
//          hardware.setModified(hardware.getCreated());
//          hardware.setModifiedBy(hardware.getCreatedBy());
//
//          saveUsers(hardware);
//
//          psInsert.setLong(1, hardware.getId());
//          psInsert.setString(2, hardware.getFixedAssetNumber());
//          psInsert.setString(3, hardware.getSerialNumber());
//          psInsert.setString(4, hardware.getMakeModel());
//          psInsert.setString(5, hardware.getType());
//          psInsert.setString(6, MysqlUtil.format(hardware.getCreated()));
//          psInsert.setString(7, formatSuperKey(hardware.getCreatedBy()));
//          psInsert.setString(8, MysqlUtil.format(hardware.getModified()));
//          psInsert.setString(9, formatSuperKey(hardware.getModifiedBy()));
//
//          log.trace(psInsert);
//          psInsert.executeUpdate();
//      }
//
//
//
//    }
//    catch (Exception e)
//    {
//      log.error(e);
//    }
//    finally
//    {
//      ConnectionUtil.closeConnection(connection, ps, rs);
//    }
//
//    timer.logStat();
//
//  }

}
