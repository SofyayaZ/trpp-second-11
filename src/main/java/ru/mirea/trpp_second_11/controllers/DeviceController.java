package ru.mirea.trpp_second_11.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с устройствами. */
@Controller("/device")
public class DeviceController {

    /** Список устройств. */
    private final List<Device> deviceList;

    /** Конструктор. */
    public DeviceController() {
        deviceList = new CsvToBeanBuilder<Device>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(Device.class).build().parse();
    }

    /**
     * Получить список устройств.
     * @return список устройств
     */
    @Get()
    public HttpResponse<List<Device>> getDevice() {
        return HttpResponse.ok(deviceList);
    }

    /**
     * Найти устройство по идентификатору.
     * @param id идентификатор устройства
     * @return Устройство, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Device> findById(Long id) {
        Optional<Device> result = deviceList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
