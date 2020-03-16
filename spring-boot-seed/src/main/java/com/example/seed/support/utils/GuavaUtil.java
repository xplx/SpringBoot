package com.example.seed.support.utils;

import com.google.common.collect.*;

import java.util.Collection;
import java.util.Set;

/**
 * @author wuxiaopeng
 * @description: 谷歌工具类
 * @date 2020/3/9 9:22
 */
public class GuavaUtil {
    public static void multisetTool() {
        String[] doc = new String[]{"关注", "加入", "关注"};
        Multiset<String> multiset = HashMultiset.create();
        for (String word : doc) {
            multiset.add(word);
        }
        //统计某个词重复数量
        System.out.println(multiset.count("关注"));
    }

    /**
     * 使用Map + List 的使用,Multimap 子类 HashMultimap，其行为类似为 Map<K,Set<V>>，
     * 也就是说 Value 对应的集合内部元素不能重复。
     * 如果需要保存的重复的元素我们可以使用 ArrayListMultimap。
     */
    public static void multimapTool() {
        Multimap<String, Integer> multimap = HashMultimap.create();
        multimap.put("a", 1);
        multimap.put("a", 2);
        multimap.put("a", 3);
        Collection<Integer> integers = multimap.get("a");
        System.out.println(integers);
    }

    /**
     * 可以用来实现键值对的双向映射需求，这样我们就可以通过 Key 查找对对应的 Value，也可以使用 Value 查找对应的 Key。
     */
    public static void BiMapTool() {
        BiMap<String, Integer> userId = HashBiMap.create();
        //BiMap#put方法不能加入重复元素， 若加入，将会抛错。如果若特定值一定要替换，可以使用 BiMap#forcePut代替。
        userId.put("Bob", 42);
        //翻转机制获取key值
        String name = userId.inverse().get(42);
        System.out.println(name);
    }

    public static void setsTool() {
        //返回在s1中存在， 但不再s2中存在的
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");
        System.out.println(Sets.difference(s1, s2));
        //返回两个集合互斥集合
        System.out.println(Sets.symmetricDifference(s1, s2));
        //返回两个集合的交集
        System.out.println(Sets.intersection(s1, s2));
        //返回两个集合的并集
        System.out.println(Sets.union(s1, s2));
    }


    public static void main(String[] args) {
        setsTool();
    }
}
