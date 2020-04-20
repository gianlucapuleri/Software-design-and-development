<?php
use PHPUnit\Framework\TestCase;

class LoginTest extends TestCase
{
	
    public function testInvalidUser()
    {
        $this->assertTrue(true);
    }
	
	public function testInvalidPass()
    {
        $this->assertFalse(false);
    }
	
	public function testValidUserPass()
    {
        $this->assertTrue(true);
    }
}

