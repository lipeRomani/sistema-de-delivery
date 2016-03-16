package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.Address;
import br.com.cantinhodamarmita.entitys.AddressDto;

public interface AddressService {
    Address getAddressFrom(AddressDto dto);
    AddressDto getAddressDtoFrom(Address address);
}
