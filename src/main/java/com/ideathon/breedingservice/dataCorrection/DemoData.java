package com.ideathon.breedingservice.dataCorrection;

import com.ideathon.breedingservice.model.Address;
import com.ideathon.breedingservice.util.IdConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DemoData {

    static Random random = new Random();

    public static List<String> getFirstNames() {
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "Jason",
                        "Robin",
                        "Cilian",
                        "Drake",
                        "Steven",
                        "Dan",
                        "Don",
                        "Steeve",
                        "Paul",
                        "Rob",
                        "Wade",
                        "Ivan",
                        "Jorge",
                        "Roberto",
                        "Jacob",
                        "Miles",
                        "Liam",
                        "Rilley",
                        "Juila",
                        "Joshua",
                        "Blake",
                        "Brittany",
                        "Katty",
                        "Clodia",
                        "Glen",
                        "Mark",
                        "Arthur",
                        "Jaime",
                        "Perry",
                        "Harold"
                )
        );

        return list;
    }

    public static List<String> getFamilyNames() {
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "Mills",
                        "Campbell",
                        "Lloyd",
                        "Barnes",
                        "Knight",
                        "Butler",
                        "Russell",
                        "Barker",
                        "Stevens",
                        "Jenkins",
                        "Dixon",
                        "Fisher",
                        "Harvey",
                        "Pearson",
                        "Murray",
                        "Graham",
                        "Fletcher",
                        "Howard",
                        "Gibson",
                        "Andrews",
                        "Walsh",
                        "Elliott",
                        "Reynolds",
                        "Saunders",
                        "Payne",
                        "Fox",
                        "Pearce",
                        "Day",
                        "Brooks",
                        "Lawrence"
                )
        );

        return list;
    }

    public static List<String> getPhoneNumbers() {
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "(209)774-5870",
                        "(508)665-3678",
                        "(234)466-9223",
                        "(260)483-2722",
                        "(215)647-7233",
                        "(225)522-1548",
                        "(229)599-5249",
                        "(413)588-9237",
                        "(818)281-7868",
                        "(845)835-8736",
                        "(830)505-4783",
                        "(402)449-7891",
                        "(682)730-6308",
                        "(215)969-1736",
                        "(540)817-6907",
                        "(816)835-7023",
                        "(301)369-6059",
                        "(805)581-3782",
                        "(430)988-2146",
                        "(442)242-5857",
                        "(631)514-6334",
                        "(513)680-9298",
                        "(215)690-1325",
                        "(650)576-1422",
                        "(620)457-8470",
                        "(717)312-8059",
                        "(312)748-3692",
                        "(501)392-2187",
                        "(703)589-6509",
                        "(304)237-5701",
                        "(316)570-2751",
                        "(281)837-5195",
                        "(610)839-2428",
                        "(616)988-3094",
                        "(319)696-3482",
                        "(615)398-1955",
                        "(669)233-4357",
                        "(207)438-9400",
                        "(407)823-8788",
                        "(816)842-2876"
                )
        );

        return list;
    }

    public static List<String> getCatNames() {
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "Bella",
                        "Tigger",
                        "Chloe",
                        "Shadow",
                        "Luna",
                        "Oreo",
                        "Olive",
                        "Kitty",
                        "Lucy",
                        "Molly",
                        "Jasper",
                        "Smokey",
                        "Gizmo",
                        "Simba",
                        "Tiger",
                        "Charlie",
                        "Angel",
                        "Jack",
                        "Lily",
                        "Peanut",
                        "Toby",
                        "Baby",
                        "Loki",
                        "Midnight",
                        "Milo",
                        "Princess",
                        "Sophie",
                        "Harley",
                        "Max",
                        "Missy",
                        "Rocky",
                        "Zoe",
                        "CoCo",
                        "Misty",
                        "Nala",
                        "Oscar",
                        "Pepper",
                        "Sasha",
                        "Buddy",
                        "Pumpkin",
                        "Kiki",
                        "Mittens"
                )
        );

        return list;
    }

    public static List<String> getDogNames() {
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "Max",
                        "Charlie",
                        "Bella",
                        "Poppy",
                        "Daisy",
                        "Buster",
                        "Alfie",
                        "Millie",
                        "Molly",
                        "Rosie",
                        "Buddy",
                        "Barney",
                        "Lola",
                        "Roxy",
                        "Cooper",
                        "Fudge",
                        "Meg",
                        "Minnie",
                        "Ozzy",
                        "Ralph",
                        "Tess",
                        "Dave",
                        "Diesel",
                        "George",
                        "Jessie",
                        "Leo",
                        "Lottie",
                        "Louie",
                        "Prince",
                        "Reggie",
                        "Simba",
                        "Rolo",
                        "Harry",
                        "Maisy",
                        "Pippa",
                        "Trixie",
                        "Bruce",
                        "Dexter"
                )
        );

        return list;
    }

    public static List<String> getHorseNames() {
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "Cinnamon",
                        "Nutmeg",
                        "Toffee",
                        "Autumn",
                        "Brownie",
                        "Copper",
                        "Rusty",
                        "Cocoa",
                        "Chocolate",
                        "Cappuccino",
                        "Teddy",
                        "Mocha",
                        "Tucker",
                        "Cody",
                        "Ranger",
                        "Franklin",
                        "Joey",
                        "Wilbur",
                        "Trigger",
                        "King",
                        "Sheriff",
                        "Blazer",
                        "Buckeye",
                        "Buck",
                        "Lego",
                        "Merlin",
                        "Amigo",
                        "Blue",
                        "Moxie"
                )
        );

        return list;
    }

    public static List<Address> getDemoAddresses() {

        List<Address> list = new ArrayList<>(
                Arrays.asList(
                       returnDemoAddress("3 4", "Keeler Avenue", "60646"),
                        returnDemoAddress("31 S", "Avalon Avenue", "60619"),
                        returnDemoAddress("2 W", "Merchandise Mart Plaza", "60654"),
                        returnDemoAddress("19 S", "Bishop Street", "60603"),
                        returnDemoAddress("12 S", "Langley Avenue", "60619"),
                        returnDemoAddress("33 S", "Chicago", "60619"),
                        returnDemoAddress("16 S", "Dearborn Street", "60605"),
                        returnDemoAddress("3 W", "30th Place", "60621"),
                        returnDemoAddress("18 N", "Nottingham Avenue", "60656"),
                        returnDemoAddress("18 N", "Rockwell Street", "60643"),
                        returnDemoAddress("13 S", "Komensky Avenue", "60652"),
                        returnDemoAddress("11 S", "Keeler Avenue", "60632"),
                        returnDemoAddress("27 S", "Kenneth Court", "60652"),
                        returnDemoAddress("23 N", "Wilton Avenue", "60653"),
                        returnDemoAddress("6 W", "Logan Boulevard", "60643"),
                        returnDemoAddress("22 S", "Brainard Avenue", "60633"),
                        returnDemoAddress("13 S", "Jeffery Avenue", "60649"),
                        returnDemoAddress("26 N", "Marmora Avenue", "60646"),
                        returnDemoAddress("26 N", "Keeler Avenue", "60646"),
                        returnDemoAddress("9 N", "Parkside Avenue", "60644"),
                        returnDemoAddress("16 S", "Paxton Avenue", "60633"),
                        returnDemoAddress("20 N", "Oleander Avenue", "60656"),
                        returnDemoAddress("23 E", "26th Street", "60616"),
                        returnDemoAddress("5 S", "King Drive", "60628"),
                        returnDemoAddress("15 E", "36th Street", "60653"),
                        returnDemoAddress("12 N", "Sioux Avenue", "60646"),
                        returnDemoAddress("13 W", "Eddy Street", "60634"),
                        returnDemoAddress("14 S", "Calhoun Avenue", "60613"),
                        returnDemoAddress("19 N", "Leamington Avenue", "60651"),
                        returnDemoAddress("29 E", "32nd Place", "60649"),
                        returnDemoAddress("15 S", "Elizabeth Street", "60620"),
                        returnDemoAddress("4 N", "Hamilton Avenue", "60659"),
                        returnDemoAddress("30 W", "Grand Avenue", "60610"),
                        returnDemoAddress("2 S", "Greenwood Avenue", "60615"),
                        returnDemoAddress("30 N", "Ravenswood Avenue", "60640"),
                        returnDemoAddress("12 N", "Alta Vista Terrace", "60613"),
                        returnDemoAddress("21 N", "Dover Street", "60640"),
                        returnDemoAddress("33 S", "Prairie Pkwy", "60616"),
                        returnDemoAddress("10 N", "Marmora Avenue", "60646"),
                        returnDemoAddress("18", "Chase Avenue", "60645"),
                        returnDemoAddress("2 S", "Tripp Avenue", "60652"),
                        returnDemoAddress("27 S", "Indiana Avenue", "60619"),
                        returnDemoAddress("24 W", "Ohio Street", "60624"),
                        returnDemoAddress("7 W", "George Street", "60634")
                ));

        return list;
    }

    private static Address returnDemoAddress(String line1, String line2, String postalCode) {
        Address address = new Address();

        address.setAddressKey(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
        address.setStateOrProvince("IL");
        address.setCountry("US");
        address.setCity("Chicago");
        address.setAddressTypeCode("SHIPPING");
        address.setDeleted(false);
        address.setPhoneExtension("");
        address.setPhoneItuNumber("");
        address.setCreatedDate(new Date());
        address.setAddressVerified(true);
        address.setModifiedDate(new Date());
        address.setLine1(line1);
        address.setLine2(line2);
        address.setLine3("");
        address.setPostalCode(postalCode);

        return address;
    }


    public static String randomValue(List<String> list) {
        int size  = list.size();

        int index = random.nextInt(size);

        return list.get(index);
    }

    public static Address randomAddress(List<Address> list) {
        int size  = list.size();

        int index = random.nextInt(size);

        return list.get(index);
    }

    public static String randomEmail(String s1, String s2) {

       return (s1 + "." + s2 + random.nextInt(100) + "@gmail.com");

    }

}
