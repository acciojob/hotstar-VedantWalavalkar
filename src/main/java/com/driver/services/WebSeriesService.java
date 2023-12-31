package com.driver.services;

import com.driver.EntryDto.WebSeriesEntryDto;
import com.driver.model.ProductionHouse;
import com.driver.model.WebSeries;
import com.driver.repository.ProductionHouseRepository;
import com.driver.repository.WebSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebSeriesService {

//    @Autowired
//    WebSeriesRepository webSeriesRepository = new WebSeriesRepository() {
//        @Override
//        public WebSeries findBySeriesName(String seriesName) {
//            return null;
//        }
//
//        @Override
//        public List<WebSeries> findAll() {
//            return null;
//        }
//
//        @Override
//        public List<WebSeries> findAll(Sort sort) {
//            return null;
//        }
//
//        @Override
//        public List<WebSeries> findAllById(Iterable<Integer> iterable) {
//            return null;
//        }
//
//        @Override
//        public <S extends WebSeries> List<S> saveAll(Iterable<S> iterable) {
//            return null;
//        }
//
//        @Override
//        public void flush() {
//
//        }
//
//        @Override
//        public <S extends WebSeries> S saveAndFlush(S s) {
//            return null;
//        }
//
//        @Override
//        public void deleteInBatch(Iterable<WebSeries> iterable) {
//
//        }
//
//        @Override
//        public void deleteAllInBatch() {
//
//        }
//
//        @Override
//        public WebSeries getOne(Integer integer) {
//            return null;
//        }
//
//        @Override
//        public <S extends WebSeries> List<S> findAll(Example<S> example) {
//            return null;
//        }
//
//        @Override
//        public <S extends WebSeries> List<S> findAll(Example<S> example, Sort sort) {
//            return null;
//        }
//
//        @Override
//        public Page<WebSeries> findAll(Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends WebSeries> S save(S s) {
//            return null;
//        }
//
//        @Override
//        public Optional<WebSeries> findById(Integer integer) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Integer integer) {
//            return false;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Integer integer) {
//
//        }
//
//        @Override
//        public void delete(WebSeries webSeries) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends WebSeries> iterable) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//
//        @Override
//        public <S extends WebSeries> Optional<S> findOne(Example<S> example) {
//            return Optional.empty();
//        }
//
//        @Override
//        public <S extends WebSeries> Page<S> findAll(Example<S> example, Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends WebSeries> long count(Example<S> example) {
//            return 0;
//        }
//
//        @Override
//        public <S extends WebSeries> boolean exists(Example<S> example) {
//            return false;
//        }
//    };

    @Autowired
    WebSeriesRepository webSeriesRepository;

//    @Autowired
//    ProductionHouseRepository productionHouseRepository = new ProductionHouseRepository() {
//    @Override
//    public List<ProductionHouse> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<ProductionHouse> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public List<ProductionHouse> findAllById(Iterable<Integer> iterable) {
//        return null;
//    }
//
//    @Override
//    public <S extends ProductionHouse> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends ProductionHouse> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<ProductionHouse> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public ProductionHouse getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends ProductionHouse> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends ProductionHouse> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<ProductionHouse> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends ProductionHouse> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public Optional<ProductionHouse> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(ProductionHouse productionHouse) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends ProductionHouse> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends ProductionHouse> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends ProductionHouse> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends ProductionHouse> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends ProductionHouse> boolean exists(Example<S> example) {
//        return false;
//    }
//};
    @Autowired
    ProductionHouseRepository productionHouseRepository;

    public Integer addWebSeries(WebSeriesEntryDto webSeriesEntryDto)throws  Exception{

        //Add a webSeries to the database and update the ratings of the productionHouse
        //Incase the seriesName is already present in the Db throw Exception("Series is already present")
        //use function written in Repository Layer for the same
        //Dont forget to save the production and webseries Repo
        WebSeries webSeries = webSeriesRepository.findBySeriesName(webSeriesEntryDto.getSeriesName());
        if(webSeries != null)
            throw new Exception("Series is already present");

        WebSeries newSeries = new WebSeries();
        newSeries.setSeriesName(webSeriesEntryDto.getSeriesName());
        newSeries.setAgeLimit(webSeriesEntryDto.getAgeLimit());
        newSeries.setRating(webSeriesEntryDto.getRating());
        newSeries.setSubscriptionType(webSeriesEntryDto.getSubscriptionType());

        Optional<ProductionHouse> optionalProductionHouse = productionHouseRepository.findById(webSeriesEntryDto.getProductionHouseId());
        if(!optionalProductionHouse.isPresent())
            throw new Exception("Production house not found");
        ProductionHouse productionHouse = optionalProductionHouse.get();
        productionHouse.getWebSeriesList().add(newSeries);
        newSeries.setProductionHouse(productionHouse);

        List<WebSeries> series = productionHouse.getWebSeriesList();
        double rating = 0;
        for(WebSeries s : series)
            rating += s.getRating();

        double avg_rating = rating / series.size();
        productionHouse.setRatings(avg_rating);

        ProductionHouse savedProductionHouse = productionHouseRepository.save(productionHouse);
        webSeries = webSeriesRepository.save(webSeries);
        return webSeries.getId();
    }

}
