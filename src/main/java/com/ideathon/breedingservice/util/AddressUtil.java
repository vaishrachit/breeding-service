package com.ideathon.breedingservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ideathon.breedingservice.model.Address;

/**
 * Addresses hard coded as file reader not working on render server.
 * @author rachit.vaish
 *
 */
public class AddressUtil {

	public List<Address> getAddress() {
		List<Address> addressList = new ArrayList<>();
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shipping","34 Keeler Avenue",null,null,"Chicago","il","60646","United States",true,true,null,"1234566","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Office","31 S Avalon Avenue",null,null,"Chicago","il","60619","United States",true,true,null,"1324433","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","2 W Merchandise Mart Plaza",null,null,"Chicago","il","60654","United States",true,true,null,"23232323","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shop","19 S Bishop Street",null,null,"Chicago","il","60603","United States",true,true,null,"3333","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","2 W Merchandise Mart Plaza",null,null,"Chicago","il","60654","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shop","19 S Bishop Street",null,null,"Chicago","il","60603","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","12 S Langley Avenue",null,null,"Chicago","il","60619","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Society","33 S Chicago",null,null,"Chicago","il","60619","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Flat","16 S Dearborn Street",null,null,"Chicago","il","60605","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","3 W 30th Place",null,null,"Chicago","il","60621","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shipping","18 N Nottingham Avenue",null,null,"Chicago","il","60656","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shipping","18 N Rockwell Street",null,null,"Chicago","il","60643","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","13 S Komensky Avenue",null,null,"Chicago","il","60652","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"House","11 S Keeler Avenue",null,null,"Chicago","il","60632","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"House","27 S Kenneth Court",null,null,"Chicago","il","60652","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Street","23 N Wilton Avenue",null,null,"Chicago","il","60653","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","6 W Logan Boulevard",null,null,"Chicago","il","60643","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shop","22 S Brainard Avenue",null,null,"Chicago","il","60633","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Shop","13 S Jeffery Avenue",null,null,"Chicago","il","60649","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","26 N Marmora Avenue",null,null,"Chicago","il","60646","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","26 N Indian Road",null,null,"Chicago","il","60646","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","9 N Parkside Avenue",null,null,"Chicago","il","60644","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","16 S Paxton Avenue",null,null,"Chicago","il","60633","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","20 N Oleander Avenue",null,null,"Chicago","il","60656","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","23 E 26th Street",null,null,"Chicago","il","60616","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","5 S King Drive",null,null,"Chicago","il","60628","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","15 E 36th Street",null,null,"Chicago","il","60653","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","13 W Eddy Street",null,null,"Chicago","il","60634","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","14 S Calhoun Avenue",null,null,"Chicago","il","60613","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","19 N Leamington Avenue",null,null,"Chicago","il","60651","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","29 Reserve Avenue",null,null,"Chicago","il","60656","United States",true,true,null,"3223","+1",null,null));	
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","15 S Elizabeth Street",null,null,"Chicago","il","60620","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","29 E 32nd Place",null,null,"Chicago","il","60649","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","4 N Hamilton Avenue",null,null,"Chicago","il","60659","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","30 W Grand Avenue",null,null,"Chicago","il","60610","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","2 S Greenwood Avenue",null,null,"Chicago","il","60615","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","12 N Sioux Avenue",null,null,"Chicago","il","60646","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","30 N Ravenswood Avenue",null,null,"Chicago","il","60640","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","12 N Alta Vista Terrace",null,null,"Chicago","il","60613","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","21 N Dover Street",null,null,"Chicago","il","60640","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","33 S Prairie Pkwy",null,null,"Chicago","il","60616","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","10 N Marmora Avenue",null,null,"Chicago","il","60646","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","18 Chase Avenue",null,null,"Chicago","il","60645","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","2 S Tripp Avenue",null,null,"Chicago","il","60652","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","27 S Indiana Avenue",null,null,"Chicago","il","60619","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","24 W Ohio Street",null,null,"Chicago","il","60624","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","7 W George Street",null,null,"Chicago","il","60634","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","1 W Ancona Street",null,null,"Chicago","il","60622","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","12 E 104th Place",null,null,"Chicago","il","60628","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Home","20 Bennett Avenue",null,null,"Chicago","il","60649","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","32 E 114th Street",null,null,"Chicago","il","60613","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","33 N Hamlin Avenue",null,null,"Chicago","il","60643","United States",true,true,null,"3223","+1",null,null));				
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","6 S Jefferson Street",null,null,"Chicago","il","60661","United States",true,true,null,"3223","+1",null,null));							
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","22 50th Street",null,null,"Chicago","il","60638","United States",true,true,null,"3223","+1",null,null));
		addressList.add(new Address(IdConverter.toStandardBinaryUUID(UUID.randomUUID()),"Store","18 S Clyde Avenue",null,null,"Chicago","il","60649","United States",true,true,null,"3223","+1",null,null));
		return addressList;
		}
}