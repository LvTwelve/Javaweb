package pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    //将购物车信息保存在Session域中

    private final Map<Integer,CartItem> itemMap = new LinkedHashMap<>();

    /**
     * 新增商品
     */
    public void addItem(CartItem cartItem){
        CartItem newItem = itemMap.get(cartItem.getId());

        //判断是否已在购物车中
        if(newItem == null){
            //不在购物车中
            itemMap.put(cartItem.getId(),cartItem);
        }
        else {
            //已在购物车中
            newItem.setCount(newItem.getCount()+1);
            newItem.setTotalPrice(newItem.getPrice().multiply(new BigDecimal(newItem.getCount())));
        }
    }

    /**
     * 删除商品
     */
    public void delItem(Integer id){
        itemMap.remove(id);
    }

    /**
     * 更改商品
     */
    public void updItem_count(Integer id,Integer count){
        CartItem updItem = itemMap.get(id);
        if(updItem != null){
            //购物车中有此商品
            updItem.setCount(count);
            updItem.setTotalPrice(updItem.getPrice().multiply(new BigDecimal(updItem.getCount())));
        }
    }

    /**
     * 清空购物车
     */
    public void clearCart(){
        itemMap.clear();
    }

    /**
     * 获取商品总数
     */
    public Integer getTotalCount(){
        Integer totalCount = 0;

        for (Map.Entry<Integer,CartItem>entry : itemMap.entrySet()) {
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }

    /**
     * 获取购物车总价格
     */
    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);

        //遍历Map获取值
        for (Map.Entry<Integer,CartItem>entry : itemMap.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }

    public Map<Integer, CartItem> getItemMap() {
        return itemMap;
    }
}
