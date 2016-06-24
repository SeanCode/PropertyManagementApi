package cn.edu.cqupt.wyglzx.model;

import cn.edu.cqupt.wyglzx.common.Config;
import cn.edu.cqupt.wyglzx.common.OutputEntityJsonView;
import cn.edu.cqupt.wyglzx.entity.ConfigEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;

import javax.persistence.Transient;

/**
 * Created by cc on 16/6/24.
 */
public class PriceConfig extends ConfigEntity {

    @Transient
    private Price price;

    @JsonView({OutputEntityJsonView.Basic.class, OutputEntityJsonView.Detail.class})
    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public static PriceConfig cloneFromConfigEntity(ConfigEntity config) {
        PriceConfig priceConfig = new PriceConfig();

        if (config != null) {
            ConfigEntity.Price price = new Gson().fromJson(config.getData(), ConfigEntity.Price.class);
            priceConfig.setId(config.getId());
            priceConfig.setData(config.getData());
            priceConfig.setType(config.getType());
            priceConfig.setCreateTime(config.getCreateTime());
            priceConfig.setUpdateTime(config.getUpdateTime());
            priceConfig.setPrice(price);
        }
        return priceConfig;
    }

}
