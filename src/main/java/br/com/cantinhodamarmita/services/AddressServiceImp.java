package br.com.cantinhodamarmita.services;

import br.com.cantinhodamarmita.daos.CityDao;
import br.com.cantinhodamarmita.daos.DistrictDao;
import br.com.cantinhodamarmita.daos.StateDao;
import br.com.cantinhodamarmita.entitys.Address;
import br.com.cantinhodamarmita.entitys.AddressDto;
import br.com.cantinhodamarmita.entitys.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressService {

    private CityDao cityDao;
    private StateDao stateDao;
    private DistrictDao districtDao;

    @Autowired
    public AddressServiceImp(CityDao cityDao, StateDao stateDao, DistrictDao districtDao) {
        this.cityDao = cityDao;
        this.stateDao = stateDao;
        this.districtDao = districtDao;
    }

    @Override
    public Address getAddressFrom(AddressDto dto) {
        District district = districtDao.findById(dto.getDistrictId());
        Address address = new Address(
                dto.getName(),
                dto.getNumber(),
                dto.getStreet(),
                dto.getComplement(),
                dto.getCep(),
                district,
                dto.getStateId(),
                dto.getCityId(),
                district.getName(),
                dto.getType()
        );
        return address;
    }

    @Override
    public AddressDto getAddressDtoFrom(Address address) {
        return new AddressDto(
                address.getName(),
                address.getNumber(),
                address.getStreet(),
                address.getComplement(),
                address.getCep(),
                address.getStateName(),
                address.getCityName(),
                address.getDistrict().getId(),
                address.getType()
        );
    }
}
