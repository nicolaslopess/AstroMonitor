import React, { Suspense, useRef } from 'react';
import { Canvas, useFrame } from '@react-three/fiber';
import { OrbitControls, Stars, useTexture } from '@react-three/drei';
import solTexture from '../../Assets/sol.jpeg';
import mercuryTexture from '../../Assets/mercurio.jpeg';
import venusTexture from '../../Assets/venus.jpeg';
import terraTexture from '../../Assets/terra.jpeg';
import marteTexture from '../../Assets/marte.jpeg';
import jupterTexture from '../../Assets/jupter.jpeg';
import uranoTexture from '../../Assets/urano.jpeg';
import asteroideTexture from '../../Assets/asteroide.jpg';
import { Box, Typography } from '@material-ui/core';
import { random } from 'lodash';

function Orbit({ radius }) {
  return (
    <mesh rotation={[Math.PI / 2, 0, 0]}>
      <torusGeometry args={[radius, 0.01, 16, 100]} />
      <meshBasicMaterial color="white" opacity={0.3} transparent />
    </mesh>
  );
}

function AsteroidField({ count }) {
  const asteroids = [];
  for (let i = 0; i < count; i++) {
    const size = random(0.06, 0.4);
    const speed = random(0.001, 0.01, true);
    const x = random(-20, 20, true);
    const y = random(10, 20);
    const z = random(-20, 20, true);
    asteroids.push(
      <Planet
        key={i}
        position={[x, y, z]}
        textureUrl={asteroideTexture}
        size={size}
        speed={speed * 5}
        movementType="falling"
      />
    );
  }
  return <>{asteroids}</>;
}

function Planet({ position, textureUrl, size, speed, movementType = "orbit" }) {
  const meshRef = useRef();
  const texture = useTexture(textureUrl);

  useFrame(() => {
    if (!meshRef.current) return;

    if (movementType === "falling") {
      meshRef.current.position.y -= speed;
      meshRef.current.position.x += random(-0.1, 0.1, true); 
      meshRef.current.position.z += random(-0.1, 0.1, true);

      if (meshRef.current.position.y < -20) {
        meshRef.current.position.y = random(20, 40);
        meshRef.current.position.x = random(-20, 20, true);
        meshRef.current.position.z = random(-20, 20, true);
      }
    } else if (movementType === "orbit") {
      meshRef.current.rotation.y += speed;
      const x = Math.sin(meshRef.current.rotation.y) * position[0];
      const z = Math.cos(meshRef.current.rotation.y) * position[0];
      meshRef.current.position.x = x;
      meshRef.current.position.z = z;
    }
  });

  return (
    <mesh ref={meshRef} position={position}>
      <sphereGeometry args={[size, 32, 32]} />
      <meshStandardMaterial map={texture} />
    </mesh>
  );
}

export default function SolarSystem() {
  return (
    <div style={{ position: 'relative', height: '100vh', width: '100vw', overflow: 'hidden' }}>
      <Canvas camera={{ position: [0, 0, 30], fov: 75 }} style={{ background: 'black' }}>
        <Suspense fallback={null}>
          <ambientLight intensity={1} />
          <pointLight position={[10, 10, 10]} />
          <Stars radius={100} depth={50} count={5000} factor={4} saturation={0} fade />
          <OrbitControls />
          {Array.from({ length: 7 }, (_, i) => <Orbit radius={2.5 + i * 2.0} />)}
          <Planet position={[0, 0, 0]} textureUrl={solTexture} size={3.5} speed={0.001} />
          <Planet position={[2.5, 0, 0]} textureUrl={mercuryTexture} size={0.53} speed={0.05} />
          <Planet position={[4.5, 0, 0]} textureUrl={venusTexture} size={0.95} speed={0.02} />
          <Planet position={[7.0, 0, 0]} textureUrl={terraTexture} size={1} speed={0.01} />
          <Planet position={[9.5, 0, 0]} textureUrl={marteTexture} size={0.7} speed={0.008} />
          <Planet position={[12.0, 0, 0]} textureUrl={jupterTexture} size={2.5} speed={0.006} />
          <Planet position={[15.0, 0, 0]} textureUrl={uranoTexture} size={1.1} speed={0.004} />
          <AsteroidField count={6} />
        </Suspense>
      </Canvas>
    </div>
  );
}
