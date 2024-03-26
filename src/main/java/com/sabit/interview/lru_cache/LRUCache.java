package com.sabit.interview.lru_cache;

import java.util.HashMap;

/**
 * Limited size, least recently used cache example
 * @param <K> key
 * @param <V> value
 */
public class LRUCache<K, V> {

	class Node<K, V> {
		K key;
		V value;
		Node<K, V> prev;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
    private HashMap<K, Node<K, V>> cache;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache() {
    	this.capacity = 100;
    	this.cache = new HashMap<>();
    	this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        
        if (node == null) {
        	
            node = new Node<>(key, value);
            cache.put(key, node);

            addToFront(node);
            
            if (cache.size() > capacity) {
                Node<K, V> tailNode = removeTail();
                cache.remove(tailNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void addToFront(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToFront(node);
    }
    
    private Node<K, V> removeTail() {
        Node<K, V> tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
    
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
