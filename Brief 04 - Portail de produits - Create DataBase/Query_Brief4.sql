/*All*/
SELECT * FROM users
SELECT * FROM administration
SELECT * FROM customer
SELECT * FROM product
SELECT * FROM vote
/*Number of Dislike In Vote*/
SELECT * FROM vote WHERE appreciation='no'
/*Number of Like In Vote*/
SELECT * FROM vote WHERE appreciation='yes'
/*Count Number Of Like & Dislike*/
SELECT COUNT(id_prd), appreciation
FROM vote
GROUP BY appreciation;
/*Number of vote for customer*/
SELECT vote.id_customer, count(vote.id_prd)
FROM vote
JOIN product 
on vote.id_prd =product.id_prd
join customer 
ON customer.id_customer= vote.id_customer
group by vote.id_customer
ORDER BY count(vote.id_prd) DESC

/*Number of vote for product*/
SELECT product.name_prd, count(vote.id_customer)as numbers_votes
FROM vote 
JOIN product
on vote.id_prd =product.id_prd
join customer 
ON customer.id_customer= vote.id_customer
group by product.name_prd
ORDER BY count(vote.id_customer) desc

/*each product and its number of likes and dislikes*/
SELECT COUNT(vote.id_prd)as Number_Of_Likes
FROM vote
JOIN product
on vote.id_prd =product.id_prd
where vote.id_prd=11 
GROUP BY vote.appreciation
having vote.appreciation='yes'







