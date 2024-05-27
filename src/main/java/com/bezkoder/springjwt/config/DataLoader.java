package com.bezkoder.springjwt.config;

import com.bezkoder.springjwt.models.Trip;
import com.bezkoder.springjwt.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final TripRepository tripRepository;

    @Autowired
    public DataLoader(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Trip> trips = Arrays.asList(
                new Trip(1L, "Japan", "https://humanidades.com/wp-content/uploads/2017/07/japon-7-e1571188430646.jpg", "$4500", "4320€", "../../../../japan", "Embark on a fascinating journey to the land of the rising sun, where tradition intertwines with modernity at every corner. Discover the serenity of zen gardens, the bustling streets of Tokyo, and the majesty of Mount Fuji.", "Senso-ji Temple in Tokyo, Himeji Castle, Itsukushima Shrine in Miyajima", "2024-06-01", "2024-06-15"),
                new Trip(2L, "Turkey", "https://media.iatiseguros.com/wp-content/uploads/2018/06/04005617/que-hacer-en-turquia-3.jpg", "$1600", "1450€", "../../../../turkey", "Explore the mystery and diversity of Turkey, a country that spans two continents. From the vibrant bazaars of Istanbul to the ancient ruins of Ephesus, each corner offers a rich history and warm hospitality.", "The Blue Mosque in Istanbul, Pamukkale, Cappadocia", "2024-07-10", "2024-07-20"),
                new Trip(3L, "Nepal", "https://lonelyplanetes.cdnstatics2.com/sites/default/files/styles/max_1300x1300/public/blog/namche_bazar_distrito_khumbu_nepal_shutterstock_360405194.jpg?itok=V_9up5ia", "$2650", "2405€", "../../../../nepal", "Immerse yourself in the natural beauty and spirituality of Nepal, home to the majestic Himalayan mountains and rich culture of Buddhism and Hinduism. From trekking routes to ancient temples, each experience is enriching.", "Mount Everest, Swayambhunath Temple, Lumbini", "2024-09-05", "2024-09-19"),
                new Trip(4L, "Turkmenistan", "https://www.advantour.com/img/turkmenistan/turkmenistan-history7.jpg", "$1350", "1105€", "../../../../turke", "Discover the fascinating history and unique architecture of Turkmenistan, a hidden gem in Central Asia. From the ruins of Merv to the gates of the White City, each place tells a story of a rich and varied past.", "The Gates of Darvaza, Ruins of Nisa, City of Merv", "2024-10-01", "2024-10-14"),
                new Trip(5L, "Thailand", "https://www.kanamitravel.com/blog/wp-content/uploads/2020/12/img_portada_128_1536854044_isan-tailandia-utopica.jpg", "$950", "870€", "../../../../thai", "Explore the tropical lushness and tranquil spirituality of Thailand, from white sandy beaches to ornate temples. With vibrant cuisine and welcoming culture, every moment in Thailand is an unforgettable adventure.", "Temple of the Emerald Buddha in Bangkok, Phi Phi Islands, Khao Sok National Park", "2024-08-15", "2024-08-25"),
                new Trip(6L, "Bali", "https://www.civitatis.com/blog/wp-content/uploads/2012/01/shutterstock_1238373562-1920x1277.jpg", "$1005", "908€", "../../../../thai", "Immerse yourself in the serenity and spirituality of Bali, where culture and nature merge into a charming experience. From terraced rice fields to hidden temples, every corner of Bali invites you to relax and rejuvenate.", "Besakih Temple, Ubud Monkey Forest, Tegallalang Rice Terrace", "2024-11-01", "2024-11-14"),
                new Trip(7L, "Punta Cana", "https://media.tacdn.com/media/attractions-content--1x-1/12/5f/c0/84.jpg", "$2504", "2258€", "../../../../thai", "Enjoy Caribbean paradise in Punta Cana, where white sandy beaches meet the crystal-clear waters of the Caribbean Sea. With a variety of water activities and luxury resorts, every moment in Punta Cana is a tropical getaway.", "Bavaro Beach, Saona Island, Ojos Indígenas Ecological Park", "2024-12-05", "2024-12-12"),
                new Trip(8L, "Riga", "https://media.tacdn.com/media/attractions-splice-spp-674x446/06/71/10/74.jpg", "$1210", "1020€", "../../../../riga", "Explore the charming beauty and rich history of Riga, the capital of Latvia. With its medieval architecture and cosmopolitan atmosphere, Riga offers a unique experience in the Baltic region.", "Historic Center of Riga, Riga Castle, Museum of the Occupation of Latvia", "2024-05-10", "2024-05-17"),
                new Trip(9L, "Budapest", "https://a.cdn-hotels.com/gdcs/production163/d345/47e14d8a-051b-4932-85d1-8f5c0363fde7.jpg", "$1090", "898€", "../../../../thai", "Embark on a journey to dazzling Budapest, where historical architecture meets modern charm along the majestic Danube River. With its famous thermal baths and vibrant nightlife, Budapest offers a unique experience in Central Europe.", "Hungarian Parliament", "2024-04-15", "2024-04-22")
        );

        tripRepository.saveAll(trips);
    }
}
